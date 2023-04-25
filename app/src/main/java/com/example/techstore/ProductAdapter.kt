package com.example.techstore

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.ProductsResponse
import com.example.techstore.databinding.CardProductBinding

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productsResponse:ProductsResponse = ProductsResponse()
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        context = parent.context
        return ProductViewHolder(CardProductBinding.inflate(LayoutInflater.from(parent.context) ,parent ,false))
    }

    override fun getItemCount(): Int {
        return productsResponse.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        with(holder)
        {
            with(productsResponse[position])
            {
                binding.textViewTitle.text = title
                binding.textViewCategory.text = category
                binding.textViewPrice.text = "$ $price"
                Glide.with(context).load(image).into(binding.imageViewProduct)
            }

        }
    }

    inner class ProductViewHolder(val binding:CardProductBinding):RecyclerView.ViewHolder(binding.root)

    fun submitProductResponse(productsResponse: ProductsResponse)
    {
        this.productsResponse = productsResponse
        notifyDataSetChanged()
    }
}