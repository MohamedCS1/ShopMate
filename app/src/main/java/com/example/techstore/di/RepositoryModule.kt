package com.example.techstore.di

import com.example.data.local.ProductDao
import com.example.data.remote.ApiService
import com.example.data.repository.ProductsLocalDataSourceImpl
import com.example.data.repository.ProductsRepositoryImpl
import com.example.data.repository.StoreProductsImpl
import com.example.domain.repository.ProductsLocalDataSource
import com.example.domain.repository.ProductsRemoteDataSource
import com.example.domain.repository.ProductsRepository
import com.example.domain.repository.StoreProducts
import com.example.domain.usecase.StoreProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

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
    fun provideStoreProduct(productDao: ProductDao, dispatcher: CoroutineDispatcher):StoreProducts
    {
        return StoreProductsImpl(productDao ,dispatcher)
    }

    @Provides
    fun provideProductsRepository(productsRemoteDataSource: ProductsRemoteDataSource ,productsLocalDataSource: ProductsLocalDataSource ,storeProducts: StoreProducts):ProductsRepository
    {
        return ProductsRepositoryImpl(productsRemoteDataSource ,productsLocalDataSource ,storeProducts)
    }
}