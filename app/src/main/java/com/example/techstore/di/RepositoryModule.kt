package com.example.techstore.di

import com.example.data.remote.ApiService
import com.example.data.repository.ProductsRepositoryImplementation
import com.example.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideProductRepository(apiService: ApiService):ProductsRepository
    {
        return ProductsRepositoryImplementation(apiService)
    }
}