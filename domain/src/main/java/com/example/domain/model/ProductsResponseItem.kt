package com.example.domain.model

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productsDatabase")
data class ProductsResponseItem(
    val category: String,
    val description: String,
    @PrimaryKey val id: Int,
    val image: String?,
    val completeImage:Bitmap?,
    val price: Double,
    @Embedded val rating: Rating,
    val title: String
)