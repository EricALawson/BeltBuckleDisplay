package com.example.beltbuckledisplay.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DisplayStateDao {
    @Query("SELECT * FROM DisplayState")
    fun allStates(): LiveData<List<DisplayState>>

    @Query("SELECT * FROM DisplayState WHERE uid = :id")
    fun getState(id: Int): LiveData<DisplayState>

    @Insert
    fun insertDisplayState(ds: DisplayState): Long

    @Update
    fun updateDisplayState(ds: DisplayState): Int
}
