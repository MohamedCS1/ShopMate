package com.example.techstore.di

import com.example.domain.repository.ProductsRepository
import com.example.domain.usecase.GetProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(productsRepository: ProductsRepository):GetProducts
    {
        return GetProducts(productsRepository)
    }
}