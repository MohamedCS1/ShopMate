package com.example.domain.repository

import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem

interface ProductsRepository {
    suspend fun getRemoteProducts():ProductsResponse
    suspend fun getLocalProducts():List<ProductsResponseItem>
    suspend fun insertProduct(productsResponseItem: ProductsResponseItem)
}