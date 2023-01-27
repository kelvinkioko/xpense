package com.xpense.data.repository

import com.xpense.data.local.XpenseDatabase
import com.xpense.data.local.dao.CurrencyDao
import com.xpense.data.local.entity.CurrencyEntity
import com.xpense.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyRepositoryImpl @Inject constructor(
    xpenseDatabase: XpenseDatabase
) : CurrencyRepository {

    private val currencyDao: CurrencyDao = xpenseDatabase.currencyDao()

    override suspend fun insertCurrency(currencyEntity: CurrencyEntity) {
        currencyDao.insertCurrency(currencyEntity = currencyEntity)
    }

    override suspend fun loadCurrency(): Flow<List<CurrencyEntity>> {
        return currencyDao.loadCurrency()
    }

    override suspend fun deleteCurrency(currencyEntity: CurrencyEntity) {
        currencyDao.deleteCurrency(currencyEntity = currencyEntity)
    }
}
