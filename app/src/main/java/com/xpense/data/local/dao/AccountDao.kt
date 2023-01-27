package com.xpense.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xpense.data.local.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(accountEntity: AccountEntity)

    @Query("UPDATE account SET name = :name WHERE account_number =:accountNumber")
    suspend fun updateAccountName(name: String, accountNumber: String): Int

    @Query("UPDATE account SET balance = :balance WHERE account_number =:accountNumber")
    suspend fun updateAccountBalance(balance: String, accountNumber: String): Int

    @Query("SELECT * FROM account")
    suspend fun loadAccounts(): Flow<AccountEntity>

    @Query("SELECT COUNT(accountNumber) FROM account")
    fun areThereAccounts(): Int

    @Query("SELECT COUNT(accountNumber) FROM account WHERE accountNumber =:accountNumber")
    fun doesAccountExistWithEmail(accountNumber: String): Int

    @Delete
    suspend fun deleteAccount(accountEntity: AccountEntity)
}
