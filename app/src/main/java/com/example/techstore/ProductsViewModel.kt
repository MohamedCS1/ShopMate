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

    private val _products:MutableStateFlow<ProductsResponse?> = MutableStateFlow(ProductsResponse())

    val products:StateFlow<ProductsResponse?> = _products

    fun getProducts()
    {
        viewModelScope.launch {
        try {
            _products.value =  getProductsUseCase()
        }catch (ex:Exception){
            _products.value = null
            println(ex)
        }

        }
    }

}

