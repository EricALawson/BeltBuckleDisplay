package com.example.beltbuckledisplay

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.beltbuckledisplay.database.DisplayState

class EditFileSettingsFragment: Fragment(R.layout.fragment_edit_file) {

    private lateinit var displayState: DisplayState
    private lateinit var imagePreview: ImageView
    private val args: EditFileSettingsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displayState = args.displayState
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imagePreview = view.findViewById(R.id.preview)
        imagePreview.setImageURI(displayState.imageUri)
    }

}
