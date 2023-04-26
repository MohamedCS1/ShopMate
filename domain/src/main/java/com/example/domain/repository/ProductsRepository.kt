package com.example.domain.repository

import com.example.domain.model.ProductsResponse

interface ProductsRepository {
    suspend fun getRemoteProducts():ProductsResponse
    suspend fun getLocalProducts():ProductsResponse
}