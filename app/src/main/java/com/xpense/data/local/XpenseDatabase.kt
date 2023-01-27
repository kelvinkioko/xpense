package com.xpense.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1
)
abstract class XpenseDatabase : RoomDatabase() {

}