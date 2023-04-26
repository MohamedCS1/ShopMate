package com.example.techstore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ProductsResponse
import com.example.domain.usecase.GetLocalProductsUseCase
import com.example.domain.usecase.GetRemoteProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getRemoteProductsUseCase:GetRemoteProductsUseCase ,private val getLocalProductsUseCase: GetLocalProductsUseCase):ViewModel() {

    private val _products:MutableStateFlow<ProductsResponse?> = MutableStateFlow(ProductsResponse())

    val products:StateFlow<ProductsResponse?> = _products

    fun getProducts()
    {
        viewModelScope.launch {
        try {
            _products.value =  getRemoteProductsUseCase()
        }catch (ex:Exception){
            _products.value = getLocalProductsUseCase()
            println(ex)
        }

        }
    }

}

