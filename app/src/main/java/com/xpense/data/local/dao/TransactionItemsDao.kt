package com.xpense.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xpense.data.local.entity.TransactionItemsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactionItems(transactionItemsEntity: TransactionItemsEntity)

    @Query("SELECT * FROM transaction_item WHERE transaction_identifier =:transactionIdentifier")
    suspend fun loadTransactionItems(transactionIdentifier: String): Flow<List<TransactionItemsEntity>>

    @Query("DELETE FROM transaction_item WHERE transaction_identifier =:transactionIdentifier")
    suspend fun deleteTransactionItemsByTID(transactionIdentifier: String)

    @Delete
    suspend fun deleteTransactionItems(transactionEntity: TransactionItemsEntity)
}
