package com.example.data.repository

import com.example.domain.model.ProductsResponse
import com.example.domain.repository.ProductsLocalDataSource
import com.example.domain.repository.ProductsRemoteDataSource
import com.example.domain.repository.ProductsRepository

class ProductsRepositoryImpl(private val productsRemoteDataSource: ProductsRemoteDataSource ,private val productsLocalDataSource: ProductsLocalDataSource):ProductsRepository {
    override suspend fun getRemoteProducts(): ProductsResponse  = productsRemoteDataSource.getProductsFromRemote()

    override suspend fun getLocalProducts(): ProductsResponse = productsLocalDataSource.getProductsFromLocal()
}