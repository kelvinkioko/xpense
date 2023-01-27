package com.xpense.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_sub_transactions")
data class AccountSubTransactionEntity(
    @PrimaryKey
    @ColumnInfo(name = "sub_transaction_identifier")
    val subTransactionIdentifier: String = "",
    @ColumnInfo(name = "transaction_identifier")
    val transactionIdentifier: String = "",
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "quantity")
    val quantity: String = "",
    @ColumnInfo(name = "amount")
    val amount: String = "",
    @ColumnInfo(name = "currency")
    val currency: String = "",
    @ColumnInfo(name = "date_updated")
    val dateUpdated: String = "",
    @ColumnInfo(name = "date_created")
    val dateCreated: String = "",
)
