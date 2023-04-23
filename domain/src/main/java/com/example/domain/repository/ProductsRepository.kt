package com.example.domain.repository

import com.example.domain.entity.ProductsResponse
import retrofit2.Call

interface ProductsRepository {
    fun getProductsFromRemote(): Call<ProductsResponse>
}