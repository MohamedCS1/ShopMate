package com.example.data.repository

import com.example.data.local.ProductDao
import com.example.domain.model.ProductsResponseItem
import com.example.domain.repository.CacheProducts
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CacheProductsImpl(private val productDao: ProductDao, private val dispatcher: CoroutineDispatcher): CacheProducts {
    override suspend fun insertProduct(productsResponseItem: ProductsResponseItem) = withContext(dispatcher) {
        productDao.insertProduct(productsResponseItem)
    }
}