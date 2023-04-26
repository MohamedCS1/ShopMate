package com.example.techstore.di

import com.example.domain.repository.ProductsRepository
import com.example.domain.usecase.GetLocalProductsUseCase
import com.example.domain.usecase.GetRemoteProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetRemoteProductUseCase(productsRepository: ProductsRepository):GetRemoteProductsUseCase
    {
        return GetRemoteProductsUseCase(productsRepository)
    }

    @Provides
    fun provideGetLocalProductUseCase(productsRepository: ProductsRepository): GetLocalProductsUseCase
    {
        return GetLocalProductsUseCase(productsRepository)
    }
}