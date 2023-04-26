package com.example.domain.usecase

import com.example.domain.repository.ProductsRepository


class GetLocalProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke() = productsRepository.getLocalProducts()
}