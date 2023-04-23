package com.example.data.remote

import com.example.domain.entity.ProductsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    fun getProducts():ProductsResponse
}