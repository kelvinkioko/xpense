package com.xpense.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class AccountEntity(
    @PrimaryKey
    @ColumnInfo(name = "account_number")
    val accountNumber: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "balance")
    val balance: String,
    @ColumnInfo(name = "account_type")
    val accountType: String,
    @ColumnInfo(name = "account_base_currency")
    val baseCurrency: String = "",
    @ColumnInfo(name = "date_updated")
    val dateUpdated: String = "",
    @ColumnInfo(name = "date_created")
    val dateCreated: String = ""
)
