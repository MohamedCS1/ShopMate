package com.example.domain.repository

import com.example.domain.model.ProductsResponseItem

interface ProductsLocalDataSource {
    suspend fun getProductsFromLocal(): List<ProductsResponseItem>
}