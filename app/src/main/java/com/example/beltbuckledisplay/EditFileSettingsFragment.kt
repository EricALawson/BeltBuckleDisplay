package com.example.beltbuckledisplay

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class EditFileSettingsFragment: Fragment(R.layout.fragment_edit_file) {

    private lateinit var imagePreview: ImageView
    val args: EditFileSettingsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUri: Uri = args.uri

        imagePreview = view.findViewById(R.id.preview)
        imagePreview.setImageURI(imageUri)
    }

}
