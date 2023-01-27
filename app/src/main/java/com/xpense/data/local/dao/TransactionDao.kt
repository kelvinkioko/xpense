package com.xpense.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xpense.data.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(TransactionEntity: TransactionEntity)

    @Query("SELECT * FROM transaction")
    suspend fun loadTransaction(): Flow<List<TransactionEntity>>

    @Delete
    suspend fun deleteTransaction(TransactionEntity: TransactionEntity)
}