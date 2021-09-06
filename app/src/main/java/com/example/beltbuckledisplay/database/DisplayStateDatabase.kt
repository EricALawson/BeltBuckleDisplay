package com.example.beltbuckledisplay.database

import android.content.Context
import android.net.Uri
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.Room

fun displayStateDao(): DisplayStateDao = DisplayStateDatabase.getInstance().DisplayStateDao()

@Database(entities = [DisplayState::class], version = 1)
@TypeConverters(UriConverters::class)
abstract class DisplayStateDatabase: RoomDatabase() {
    abstract fun DisplayStateDao(): DisplayStateDao

    companion object {
        private lateinit var context: Context
        //must be called in Application before using getInstance
        fun setContext(context: Context) {
            this.context = context
        }
        private lateinit var instance: DisplayStateDatabase
        fun getInstance(): DisplayStateDatabase {
            val i = instance
            if (i != null) {
                return i
            }

            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created: DisplayStateDatabase = Room.databaseBuilder(
                        context,
                        DisplayStateDatabase::class.java,
                        "displayState.db"
                    ).build()
                    instance = created
                    created
                }
            }
        }
    }
}

class UriConverters {
    @TypeConverter
    fun fromString(value: String?): Uri? {
        return if (value == null) null else Uri.parse(value)
    }

    @TypeConverter
    fun toString(uri: Uri?): String? {
        return uri?.toString()
    }
}