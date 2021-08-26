package com.example.beltbuckledisplay.database

import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [DisplayState::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun DisplayStateDao(): DisplayStateDao
}