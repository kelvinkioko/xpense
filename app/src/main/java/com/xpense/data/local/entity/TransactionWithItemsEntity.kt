package com.xpense.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TransactionWithItemsEntity(
    @Embedded val transaction: TransactionEntity,
    @Relation(
        parentColumn = "transaction_identifier",
        entityColumn = "transaction_identifier"
    )
    val transactionItems: List<TransactionItemsEntity>
)
