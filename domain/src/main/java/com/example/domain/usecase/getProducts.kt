package com.example.domain.usecase

import com.example.domain.repository.ProductsRepository

class getProducts(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke() = productsRepository.getProductsFromRemote()
}