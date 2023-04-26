package com.example.data.repository

import com.example.data.local.ProductDao
import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem
import com.example.domain.repository.ProductsLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ProductsLocalDataSourceImpl(private val productDao: ProductDao, private val dispatcher:CoroutineDispatcher):ProductsLocalDataSource {
    override suspend fun getProductsFromLocal(): List<ProductsResponseItem> = withContext(dispatcher){ productDao.getAllProducts() }
}