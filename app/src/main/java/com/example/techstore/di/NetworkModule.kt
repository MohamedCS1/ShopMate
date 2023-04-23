package com.example.techstore.di

import com.example.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    final val BASE_URL= "https://fakestoreapi.com"

    @Provides
    @Singleton
    fun provideOkHttp():OkHttpClient
    {
        return OkHttpClient().newBuilder().connectTimeout(20 ,TimeUnit.SECONDS).readTimeout(20 ,TimeUnit.SECONDS).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit
    {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService
    {
        return retrofit.create(ApiService::class.java)
    }

}