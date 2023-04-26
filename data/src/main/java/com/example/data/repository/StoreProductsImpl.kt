package com.example.data.repository

import com.example.data.local.ProductDao
import com.example.domain.model.ProductsResponseItem
import com.example.domain.repository.ProductsRepository
import com.example.domain.repository.StoreProducts
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class StoreProductsImpl(private val productDao: ProductDao, private val dispatcher: CoroutineDispatcher): StoreProducts {
    override suspend fun insertProduct(productsResponseItem: ProductsResponseItem) = withContext(dispatcher) {
        productDao.insertProduct(productsResponseItem)
    }
}