package com.example.techstore

import com.example.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideOkHttp():OkHttpClient
    {
        return OkHttpClient().newBuilder().connectTimeout(20 ,TimeUnit.SECONDS).readTimeout(20 ,TimeUnit.SECONDS).build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit
    {
        return Retrofit.Builder().baseUrl("").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideApiService(retrofit: Retrofit):ApiService
    {
        return retrofit.create(ApiService::class.java)
    }

}