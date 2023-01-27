package com.xpense.domain.repository

import com.xpense.data.local.entity.TransactionEntity
import com.xpense.data.local.entity.TransactionItemsEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    // region: Transaction
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    suspend fun loadTransaction(accountNumber: String): Flow<List<TransactionEntity>>

    suspend fun deleteTransactionItemsByAN(accountNumber: String)

    suspend fun deleteTransaction(transactionEntity: TransactionEntity)
    // endregion

    // region: Transaction Items
    suspend fun insertTransactionItems(transactionItemsEntity: TransactionItemsEntity)

    suspend fun loadTransactionItems(transactionIdentifier: String): Flow<List<TransactionItemsEntity>>

    suspend fun deleteTransactionItemsByTID(transactionIdentifier: String)

    suspend fun deleteTransactionItems(transactionEntity: TransactionItemsEntity)
    // endregion
}
