package com.example.beltbuckledisplay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beltbuckledisplay.database.DisplayStateDatabase
import com.example.beltbuckledisplay.database.DisplayState
import com.example.beltbuckledisplay.database.DisplayStateDao

class DisplayGraphViewModel: ViewModel() {
    private val currentDisplayState: MutableLiveData<DisplayState> = MutableLiveData()
    fun getCurrent(): LiveData<DisplayState> {
        return currentDisplayState
    }
    fun setCurrent(ds: DisplayState) {
        currentDisplayState.value = ds
    }

    public val allStates: LiveData<List<DisplayState>> by lazy {
        DisplayStateDatabase.getInstance().DisplayStateDao().allStates()
    }
}
