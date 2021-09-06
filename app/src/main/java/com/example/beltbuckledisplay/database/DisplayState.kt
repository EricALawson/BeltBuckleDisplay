package com.example.beltbuckledisplay.database

import android.net.Uri
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class DisplayState(
    @PrimaryKey(autoGenerate = true) var uid: Long,
    @ColumnInfo(name = "image_uri") var imageUri: Uri,
    @ColumnInfo(name = "name") var name: String,
) : Parcelable