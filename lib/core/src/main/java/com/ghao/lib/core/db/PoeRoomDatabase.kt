package com.ghao.lib.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ghao.lib.core.data.Transaction

@Database(entities = [Transaction::class], version = 1)
// @TypeConverters(DateTimeConverter::class)
abstract class PoeRoomDatabase : RoomDatabase() {

    abstract fun poeEconomyDao(): PoeEconomyDao

    companion object {
        const val DB_NAME = "poe_economy_db"
    }
}
