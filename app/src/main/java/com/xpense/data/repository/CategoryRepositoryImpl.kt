package com.xpense.data.repository

import com.xpense.data.local.XpenseDatabase
import com.xpense.data.local.dao.CategoryDao
import com.xpense.data.local.entity.CategoryEntity
import com.xpense.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    xpenseDatabase: XpenseDatabase
) : CategoryRepository {

    private val categoryDao: CategoryDao = xpenseDatabase.categoryDao()

    override suspend fun insertCategory(categoryEntity: CategoryEntity) {
        categoryDao.insertCategory(categoryEntity = categoryEntity)
    }

    override suspend fun loadCategory(): Flow<List<CategoryEntity>> {
        return categoryDao.loadCategory()
    }

    override suspend fun deleteCategory(categoryEntity: CategoryEntity) {
        categoryDao.deleteCategory(categoryEntity = categoryEntity)
    }
}
