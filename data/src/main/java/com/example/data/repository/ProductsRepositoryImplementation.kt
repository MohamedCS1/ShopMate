package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.entity.ProductsResponse
import com.example.domain.repository.ProductsRepository
import retrofit2.Call

class ProductsRepositoryImplementation(private val apiService: ApiService):ProductsRepository{

    override fun getProductsFromRemote(): Call<ProductsResponse> = apiService.getProducts()

}