package com.example.techstore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem
import com.example.domain.usecase.StoreProductsUseCase
import com.example.domain.usecase.GetLocalProductsUseCase
import com.example.domain.usecase.GetRemoteProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getRemoteProductsUseCase:GetRemoteProductsUseCase ,private val getLocalProductsUseCase: GetLocalProductsUseCase ,private val storeProductsUseCase: StoreProductsUseCase):ViewModel() {

    private val _products:MutableStateFlow<ProductsResponse?> = MutableStateFlow(ProductsResponse())

    val products:StateFlow<ProductsResponse?> = _products

    private val productsResponse = ProductsResponse()

    fun getProducts()
    {
        viewModelScope.launch {
        try {
            _products.value =  getRemoteProductsUseCase()
        }catch (ex:Exception){
            productsResponse.addAll(getLocalProductsUseCase())
            _products.value = productsResponse
            println(ex)
        }

        }
    }

    fun insertProduct(productsResponseItem: ProductsResponseItem)
    {
        viewModelScope.launch {
            storeProductsUseCase.insertProduct(productsResponseItem)
        }
    }

}

