package com.example.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem


@Dao
interface ProductDao {

    @Insert
    fun insertProduct(productsResponse: ProductsResponse)

    @Query("select * from productsDatabase")
    fun getAllProducts():ProductsResponse
}