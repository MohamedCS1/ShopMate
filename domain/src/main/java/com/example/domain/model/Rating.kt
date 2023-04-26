package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rating(
    @PrimaryKey val count: Int,
    val rate: Double
)