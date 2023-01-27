package com.xpense.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xpense.data.local.entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currencyEntity: CurrencyEntity)

    @Query("SELECT * FROM currency")
    suspend fun loadCurrency(): Flow<List<CurrencyEntity>>

    @Delete
    suspend fun deleteCurrency(currencyEntity: CurrencyEntity)
}
