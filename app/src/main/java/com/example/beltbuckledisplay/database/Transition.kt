package com.example.beltbuckledisplay.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = DisplayState::class,
            parentColumns = ["id"],
            childColumns = ["start"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DisplayState::class,
            parentColumns = ["id"],
            childColumns = ["end"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Transition (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "start") var start: Int,
    @ColumnInfo(name = "end") var end: Int
)