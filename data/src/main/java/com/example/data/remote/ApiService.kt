package com.example.data.remote

import com.example.domain.model.ProductsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProducts():ProductsResponse
}