package com.example.beltbuckledisplay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beltbuckledisplay.database.DisplayStateDatabase
import com.example.beltbuckledisplay.database.DisplayState
import com.example.beltbuckledisplay.database.DisplayStateDao

class DisplaySequenceViewModel: ViewModel() {
//    private var startState: DisplayState? = null
//    private var currentState: DisplayState? = null
//    private var allStates: MutableList<DisplayState> = mutableListOf()

    public val allStates: LiveData<List<DisplayState>> by lazy {
        DisplayStateDatabase.getInstance().DisplayStateDao().allStates()
    }
}
