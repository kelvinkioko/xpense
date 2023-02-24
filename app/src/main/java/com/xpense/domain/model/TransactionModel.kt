package com.xpense.domain.model

import java.time.LocalDateTime

data class TransactionModel(
    val transactionIdentifier: String = "",
    val accountNumber: String = "",
    val transactionName: String = "",
    val transactionDate: String = "",
    val amount: String = "",
    val currency: String = "",
    val category: String = "",
    val transactionType: String = "",
    val additionalNote: String = "",
    val dateUpdated: LocalDateTime,
    val dateCreated: LocalDateTime
)
