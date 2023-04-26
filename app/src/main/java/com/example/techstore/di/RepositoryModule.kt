package com.example.techstore.di

import com.example.data.local.ProductDao
import com.example.data.remote.ApiService
import com.example.data.repository.ProductsLocalDataSourceImpl
import com.example.data.repository.ProductsRepositoryImpl
import com.example.domain.repository.ProductsLocalDataSource
import com.example.domain.repository.ProductsRemoteDataSource
import com.example.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRemoteProductRepository(apiService: ApiService):ProductsRemoteDataSource
    {
        return com.example.data.repository.ProductsRemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideLocalProductsRepository(productDao: ProductDao, dispatcher: CoroutineDispatcher):ProductsLocalDataSource
    {
        return ProductsLocalDataSourceImpl(productDao ,dispatcher)
    }

    @Provides
    fun provideProductsRepository(productsRemoteDataSource: ProductsRemoteDataSource ,productsLocalDataSource: ProductsLocalDataSource):ProductsRepository
    {
        return ProductsRepositoryImpl(productsRemoteDataSource ,productsLocalDataSource)
    }
}