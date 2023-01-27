package com.xpense.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_transactions")
data class AccountTransactionEntity(
    @PrimaryKey
    @ColumnInfo(name = "transaction_identifier")
    val transactionIdentifier: String = "",
    @ColumnInfo(name = "account_number")
    val accountNumber: String = "",
    @ColumnInfo(name = "name")
    val transactionName: String = "",
    @ColumnInfo(name = "transact_date")
    val transactionDate: String = "",
    @ColumnInfo(name = "amount")
    val amount: String = "",
    @ColumnInfo(name = "currency")
    val currency: String = "",
    @ColumnInfo(name = "category")
    val category: String = "",
    @ColumnInfo(name = "additional_note")
    val additionalNote: String = "",
    @ColumnInfo(name = "date_updated")
    val dateUpdated: String = "",
    @ColumnInfo(name = "date_created")
    val dateCreated: String = "",
)
