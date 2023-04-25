package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.entity.ProductsResponse
import com.example.domain.repository.ProductsRepository
import retrofit2.Call

class ProductsRepositoryImplementation(private val apiService: ApiService ,private val productsDataBase:ProductsDatabase):ProductsRepository{

    override suspend fun getProductsFromRemote():ProductsResponse = apiService.getProducts()
    override suspend fun getProductsFromLocal(): ProductsResponse =

}