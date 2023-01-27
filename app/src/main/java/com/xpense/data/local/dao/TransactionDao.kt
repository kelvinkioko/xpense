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
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM transaction WHERE account_number =:accountNumber")
    suspend fun loadTransaction(accountNumber: String): Flow<List<TransactionEntity>>

    @Query("DELETE FROM transaction WHERE account_number =:accountNumber")
    suspend fun deleteTransactionItemsByAN(accountNumber: String)

    @Delete
    suspend fun deleteTransaction(transactionEntity: TransactionEntity)
}
