package com.example.techstore.presentation.ui.detail

import android.view.View
import com.example.domain.model.ProductsResponseItem
import com.example.techstore.util.DataSource

interface onProductClickListener {
    fun onProductClick(itemView: View, productsResponseItem: ProductsResponseItem, dataSource: DataSource)
}