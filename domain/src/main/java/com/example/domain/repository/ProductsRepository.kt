package com.example.domain.repository

import com.example.domain.entity.ProductsResponse
import retrofit2.Call

interface ProductsRepository {
    suspend fun getProductsFromRemote():ProductsResponse
    suspend fun getProductsFromLocal():ProductsResponse
}