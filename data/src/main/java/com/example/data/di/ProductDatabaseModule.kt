package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.local.ProductDao
import com.example.data.local.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context:Application):ProductsDatabase
    {
        return Room.databaseBuilder(context ,ProductsDatabase::class.java ,"productsDatabase")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(productsDatabase: ProductsDatabase):ProductDao
    {
        return productsDatabase.productDao()
    }
}