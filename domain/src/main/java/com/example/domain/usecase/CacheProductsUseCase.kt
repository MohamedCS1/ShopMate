package com.example.domain.usecase

import com.example.domain.model.ProductsResponseItem
import com.example.domain.repository.ProductsRepository

class CacheProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend fun insertProduct(productsResponseItem: ProductsResponseItem) = productsRepository.insertProduct(productsResponseItem)
}