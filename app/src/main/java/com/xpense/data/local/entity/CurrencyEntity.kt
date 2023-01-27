package com.xpense.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "currency")
data class CurrencyEntity(
    @ColumnInfo(name = "currency_code")
    val currencyCode: String,
    @ColumnInfo(name = "currency_name")
    val currencyName: String
)
