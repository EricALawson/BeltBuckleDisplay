package com.example.beltbuckledisplay

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.beltbuckledisplay.database.DisplayState
import com.example.beltbuckledisplay.database.DisplayStateDatabase

class EditFileSettingsFragment: Fragment(R.layout.fragment_edit_file) {

    private lateinit var original: DisplayState
    private lateinit var editing: DisplayState
    private lateinit var imagePreview: ImageView
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var resetButton: Button
    private val args: EditFileSettingsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        original = args.displayState
        editing = original.copy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imagePreview = view.findViewById(R.id.preview)
        imagePreview.setImageURI(editing.imageUri)

        saveButton = view.findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            DisplayStateDatabase.getInstance().DisplayStateDao().insertDisplayState(editing)
        }

        cancelButton = view.findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener {
            //TODO: cancel button to back stack
        }

        resetButton = view.findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            editing = original.copy()
        }
    }

}
