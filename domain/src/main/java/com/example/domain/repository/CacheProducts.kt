package com.example.domain.repository

import com.example.domain.model.ProductsResponseItem

interface CacheProducts {
    suspend fun insertProduct(productsResponseItem: ProductsResponseItem)
}