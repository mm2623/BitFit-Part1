package com.example.bitfitpart1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FitDao {
    @Query("SELECT * FROM fit_table")
    fun getAll(): Flow<List<FitEntity>>

    @Insert
    fun insertAll(fit: List<FitEntity>)

    @Query("DELETE FROM fit_table")
    fun deleteAll()
}