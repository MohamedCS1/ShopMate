package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.model.ProductsResponse
import com.example.domain.model.ProductsResponseItem
import com.example.domain.model.Rating


@Database(entities = [ProductsResponse::class ,ProductsResponseItem::class ,Rating::class] , version = 4 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductsDatabase:RoomDatabase() {
    abstract fun productDao():ProductDao
}