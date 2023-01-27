package com.xpense.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_item")
data class TransactionItemsEntity(
    @PrimaryKey
    @ColumnInfo(name = "item_identifier")
    val itemIdentifier: String = "",
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
