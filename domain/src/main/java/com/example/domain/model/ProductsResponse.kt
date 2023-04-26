package com.example.domain.model

import androidx.room.Entity

@Entity(tableName = "productsDatabase")
class ProductsResponse : ArrayList<ProductsResponseItem>()