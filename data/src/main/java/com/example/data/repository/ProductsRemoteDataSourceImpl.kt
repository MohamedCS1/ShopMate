package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.model.ProductsResponse
import com.example.domain.repository.ProductsRemoteDataSource

class ProductsRemoteDataSourceImpl(private val apiService: ApiService): ProductsRemoteDataSource {
    override suspend fun getProductsFromRemote():ProductsResponse = apiService.getProducts()

}