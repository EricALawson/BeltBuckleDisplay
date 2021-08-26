package com.example.beltbuckledisplay.database

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DisplayState(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "image_uri") val imageLocation: Uri,
    @ColumnInfo(name = "name") val name: String,
)