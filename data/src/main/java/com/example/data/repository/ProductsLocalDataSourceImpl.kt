package com.example.data.repository

import com.example.data.local.ProductDao
import com.example.domain.model.ProductsResponse
import com.example.domain.repository.ProductsLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ProductsLocalDataSourceImpl(private val productDao: ProductDao, private val dispatcher:CoroutineDispatcher):ProductsLocalDataSource {
    override suspend fun getProductsFromLocal(): ProductsResponse = withContext(dispatcher){ productDao.getAllProducts() }
}