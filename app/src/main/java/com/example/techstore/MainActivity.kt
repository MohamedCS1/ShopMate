package com.example.techstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.ProductsResponse
import com.example.techstore.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val productsViewModel:ProductsViewModel by viewModels()

    lateinit var binding:ActivityMainBinding
    lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductAdapter()

        initRecyclerView()

        productsViewModel.getProducts()

        lifecycleScope.launch {
            productsViewModel.products.collect {
                if (it == null) Toast.makeText(this@MainActivity ,"Something wrong please try again" ,Toast.LENGTH_SHORT).show()
                else productAdapter.submitProductResponse(it?: ProductsResponse())
            }
        }
    }

    fun initRecyclerView() {
        binding.recyclerViewProducts.apply {
            adapter = productAdapter
            layoutManager = GridLayoutManager(this@MainActivity ,2)
        }
    }
}