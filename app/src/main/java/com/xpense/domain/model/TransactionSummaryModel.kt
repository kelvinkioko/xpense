package com.xpense.domain.model

import java.time.LocalDateTime

data class TransactionSummaryModel(
    val transactionDate: LocalDateTime,
    val transactionSummaryAmount: String,
    val transactions: List<TransactionModel> = emptyList()
)
