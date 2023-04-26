package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.ProductsResponseItem


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productsResponseItem: ProductsResponseItem)

    @Query("select * from productsDatabase")
    fun getAllProducts():List<ProductsResponseItem>
}