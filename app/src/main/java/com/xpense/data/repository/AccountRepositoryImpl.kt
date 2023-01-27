package com.xpense.data.repository

import com.xpense.data.local.XpenseDatabase
import com.xpense.data.local.dao.AccountDao
import com.xpense.data.local.entity.AccountEntity
import com.xpense.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountRepositoryImpl @Inject constructor(
    xpenseDatabase: XpenseDatabase
) : AccountRepository {

    val accountDao: AccountDao = xpenseDatabase.accountDao()

    override suspend fun insertAccount(accountEntity: AccountEntity) {
        accountDao.insertAccount(accountEntity = accountEntity)
    }

    override suspend fun updateAccountName(name: String, accountNumber: String): Int {
        return accountDao.updateAccountName(name = name, accountNumber = accountNumber)
    }

    override suspend fun updateAccountBalance(balance: String, accountNumber: String): Int {
        return accountDao.updateAccountBalance(balance = balance, accountNumber = accountNumber)
    }

    override suspend fun loadAccounts(): Flow<List<AccountEntity>> {
        return accountDao.loadAccounts()
    }

    override suspend fun areThereAccounts(): Int {
        return accountDao.areThereAccounts()
    }

    override suspend fun doesAccountExistWithEmail(accountNumber: String): Int {
        return accountDao.doesAccountExistWithEmail(accountNumber = accountNumber)
    }

    override suspend fun deleteAccount(accountEntity: AccountEntity) {
        accountDao.deleteAccount(accountEntity = accountEntity)
    }
}
