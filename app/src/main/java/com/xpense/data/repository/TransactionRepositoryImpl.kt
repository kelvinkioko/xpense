package com.xpense.data.repository

import com.xpense.data.local.XpenseDatabase
import com.xpense.data.local.dao.TransactionDao
import com.xpense.data.local.dao.TransactionItemsDao
import com.xpense.data.local.entity.TransactionEntity
import com.xpense.data.local.entity.TransactionItemsEntity
import com.xpense.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    xpenseDatabase: XpenseDatabase
) : TransactionRepository {

    private val transactionDao: TransactionDao = xpenseDatabase.transactionDao()
    private val transactionItemsDao: TransactionItemsDao = xpenseDatabase.transactionItemsDao()

    // region: Transaction
    override suspend fun insertTransaction(transactionEntity: TransactionEntity) {
        transactionDao.insertTransaction(transactionEntity = transactionEntity)
    }

    override suspend fun loadTransaction(accountNumber: String): Flow<List<TransactionEntity>> {
        return transactionDao.loadTransaction(accountNumber = accountNumber)
    }

    override suspend fun deleteTransactionItemsByAN(accountNumber: String) {
        transactionDao.deleteTransactionItemsByAN(accountNumber = accountNumber)
    }

    override suspend fun deleteTransaction(transactionEntity: TransactionEntity) {
        transactionDao.deleteTransaction(transactionEntity = transactionEntity)
    }
    // endregion

    // region: Transaction Items
    override suspend fun insertTransactionItems(transactionItemsEntity: TransactionItemsEntity) {
        transactionItemsDao.insertTransactionItems(transactionItemsEntity = transactionItemsEntity)
    }

    override suspend fun loadTransactionItems(
        transactionIdentifier: String
    ): Flow<List<TransactionItemsEntity>> {
        return transactionItemsDao.loadTransactionItems(
            transactionIdentifier = transactionIdentifier
        )
    }

    override suspend fun deleteTransactionItemsByTID(transactionIdentifier: String) {
        transactionItemsDao.deleteTransactionItemsByTID(
            transactionIdentifier = transactionIdentifier
        )
    }

    override suspend fun deleteTransactionItems(transactionEntity: TransactionItemsEntity) {
        transactionItemsDao.deleteTransactionItems(transactionEntity = transactionEntity)
    }
    // endregion
}
