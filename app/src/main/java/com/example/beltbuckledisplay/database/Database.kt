package com.example.beltbuckledisplay.database

import android.net.Uri
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [DisplayState::class], version = 1)
@TypeConverters(UriConverters::class)
abstract class Database: RoomDatabase() {
    abstract fun DisplayStateDao(): DisplayStateDao
}

class UriConverters {
    @TypeConverter
    fun fromString(value: String?): Uri? {
        return if (value == null) null else Uri.parse(value)
    }

    @TypeConverter
    fun toString(uri: Uri?): String? {
        return uri.toString()
    }
}