package com.example.domain.repository

import com.example.domain.entity.ProductsResponse

interface ProductsRepository {
    fun getProductsFromRemote():ProductsResponse
}