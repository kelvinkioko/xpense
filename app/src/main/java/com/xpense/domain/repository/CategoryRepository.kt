package com.xpense.domain.repository

import com.xpense.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun insertCategory(categoryEntity: CategoryEntity)

    suspend fun loadCategory(): Flow<List<CategoryEntity>>

    suspend fun deleteCategory(categoryEntity: CategoryEntity)
}
