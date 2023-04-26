package com.example.domain.repository

import com.example.domain.model.ProductsResponse

interface ProductsRemoteDataSource {
    suspend fun getProductsFromRemote():ProductsResponse
}