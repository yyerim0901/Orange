package com.keelim.orange.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.keelim.orange.data.dao.HistoryDao
import com.keelim.orange.data.model.History


@Database(version = 1,
    entities = [History::class],
    autoMigrations = [
//        AutoMigration(from = 1, to = 2 )
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}