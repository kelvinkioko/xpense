package com.xpense.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
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
abstract class XpenseDatabase : RoomDatabase()
