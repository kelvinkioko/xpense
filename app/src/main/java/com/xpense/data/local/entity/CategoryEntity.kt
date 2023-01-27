package com.xpense.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "category")
data class CategoryEntity(
    @ColumnInfo(name = "category_name")
    val categoryName: String
)
