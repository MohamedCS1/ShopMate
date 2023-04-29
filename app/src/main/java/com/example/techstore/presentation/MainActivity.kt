package com.example.techstore.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem
import com.example.techstore.databinding.ActivityMainBinding
import com.example.techstore.util.BitmapUtil.getBitmap
import com.example.techstore.util.DataSource
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val productsViewModel: ProductsViewModel by viewModels()

    lateinit var binding:ActivityMainBinding
    lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemAnimation()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductAdapter()

        initRecyclerView()

        productsViewModel.getProducts()

        lifecycleScope.launch {
            productsViewModel.products.collect { productsResponse ->
                if (productsResponse == null) Toast.makeText(this@MainActivity ,"Something wrong please try again" ,Toast.LENGTH_SHORT).show()
                else
                {
                    productAdapter.setDataSource(DataSource.Remote)
                    productAdapter.submitProductResponse(productsResponse?: ProductsResponse())
                    productsResponse.forEach {
                        product->
                        val productImage = async {getBitmap(this@MainActivity ,product.image?:"")}
                        productsViewModel.insertProduct(ProductsResponseItem(product.category ,product.description ,product.id ,null,productImage.await() ,product.price ,product.rating ,product.title))
                        binding.progressBar.visibility = View.INVISIBLE
                    }
                }
            }
        }

        lifecycleScope.launch {
            productsViewModel.localeProducts.collect{
                productAdapter.setDataSource(DataSource.Local)
                productAdapter.submitProductResponse(it!!)
                binding.progressBar.visibility = View.INVISIBLE
            }
        }

        productAdapter.onProductClick(object :onProductClickListener{
            override fun onProductClick(
                itemView: View,
                productsResponseItem: ProductsResponseItem,
                dataSource: DataSource
            ) {
                val intent = Intent(this@MainActivity ,DetailActivity::class.java)
                val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, itemView, "transitionNameA" )
                intent.putExtra("product" ,productsResponseItem?: ProductsResponse())
                intent.putExtra("dataSource" ,dataSource)
                startActivity(intent ,options.toBundle())
            }
        })


    }

    private fun initRecyclerView() {
        binding.recyclerViewProducts.apply {
            adapter = productAdapter
            layoutManager = GridLayoutManager(this@MainActivity ,2)
        }
    }

    private fun itemAnimation()
    {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
    }
}
