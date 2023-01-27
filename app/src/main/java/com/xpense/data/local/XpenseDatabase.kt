package com.xpense.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xpense.data.local.dao.AccountDao
import com.xpense.data.local.dao.CategoryDao
import com.xpense.data.local.dao.CurrencyDao
import com.xpense.data.local.dao.TransactionDao
import com.xpense.data.local.dao.TransactionItemsDao
import com.xpense.data.local.entity.AccountEntity
import com.xpense.data.local.entity.CategoryEntity
import com.xpense.data.local.entity.CurrencyEntity
import com.xpense.data.local.entity.TransactionEntity
import com.xpense.data.local.entity.TransactionItemsEntity

@Database(
    entities = [
        AccountEntity::class,
        CategoryEntity::class,
        CurrencyEntity::class,
        TransactionEntity::class,
        TransactionItemsEntity::class
    ],
    version = 1
)
abstract class XpenseDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao
    abstract fun categoryDao(): CategoryDao
    abstract fun currencyDao(): CurrencyDao
    abstract fun transactionDao(): TransactionDao
    abstract fun transactionItemsDao(): TransactionItemsDao
}
