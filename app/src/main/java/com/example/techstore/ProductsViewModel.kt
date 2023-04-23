package com.example.techstore

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.ProductsResponse
import com.example.domain.usecase.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProductsUseCase:GetProducts):ViewModel() {

    private val _products:MutableStateFlow<ProductsResponse?> = MutableStateFlow(null)

    val products:StateFlow<ProductsResponse?> = _products

    fun getProducts()
    {
        viewModelScope.launch {
            getProductsUseCase().enqueue(object :Callback<ProductsResponse>{
                override fun onResponse(
                    call: Call<ProductsResponse>,
                    response: Response<ProductsResponse>
                ) {
                    _products.value = response.body()
                }

                override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                    _products.value = null
                }
            })
        }

    }

}