package com.example.domain.repository

import com.example.domain.model.ProductsResponse

interface ProductsLocalDataSource {
    suspend fun getProductsFromLocal(): ProductsResponse
}