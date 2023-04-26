package com.example.data.repository

import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem
import com.example.domain.repository.ProductsLocalDataSource
import com.example.domain.repository.ProductsRemoteDataSource
import com.example.domain.repository.ProductsRepository
import com.example.domain.repository.CacheProducts

class ProductsRepositoryImpl(private val productsRemoteDataSource: ProductsRemoteDataSource ,private val productsLocalDataSource: ProductsLocalDataSource ,private val cacheProducts: CacheProducts):ProductsRepository {
    override suspend fun getRemoteProducts(): ProductsResponse  = productsRemoteDataSource.getProductsFromRemote()
    override suspend fun getLocalProducts(): List<ProductsResponseItem> = productsLocalDataSource.getProductsFromLocal()
    override suspend fun insertProduct(productsResponseItem: ProductsResponseItem) = cacheProducts.insertProduct(productsResponseItem)
}