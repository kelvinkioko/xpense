package com.xpense.domain.repository

import com.xpense.data.local.entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    suspend fun insertCurrency(currencyEntity: CurrencyEntity)

    suspend fun loadCurrency(): Flow<List<CurrencyEntity>>

    suspend fun deleteCurrency(currencyEntity: CurrencyEntity)
}
