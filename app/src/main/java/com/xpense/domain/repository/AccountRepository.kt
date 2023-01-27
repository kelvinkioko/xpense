package com.xpense.domain.repository

import com.xpense.data.local.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun insertAccount(accountEntity: AccountEntity)

    suspend fun updateAccountName(name: String, accountNumber: String): Int

    suspend fun updateAccountBalance(balance: String, accountNumber: String): Int

    suspend fun loadAccounts(): Flow<List<AccountEntity>>

    suspend fun areThereAccounts(): Int

    suspend fun doesAccountExistWithEmail(accountNumber: String): Int

    suspend fun deleteAccount(accountEntity: AccountEntity)
}
