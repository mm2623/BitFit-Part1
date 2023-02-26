package com.example.bitfitpart1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fit_table")
data class FitEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "food_name") val food_name: String?,
    @ColumnInfo(name = "food_calories") val food_calories: String?
)