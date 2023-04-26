package com.example.domain.repository

import com.example.domain.model.ProductsResponseItem

interface StoreProducts {
    suspend fun insertProduct(productsResponseItem: ProductsResponseItem)
}