package com.example.beltbuckledisplay

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

const val ADD_FILE = 1

class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by viewModels()
    private val startButton: Button = findViewById(R.id.startButton)
    private val addFileButton: Button = findViewById(R.id.addFileButton)
    private val fileSelector = registerForActivityResult(
        ActivityResultContracts.GetContent()) {
            uri: Uri? ->
                startActivity(
                    Intent(this,EditFileSettingsActivity::class.java)
                        .setData(uri)
                )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            startActivity(Intent(this, DisplayModeActivity::class.java))
        }

        addFileButton.setOnClickListener {
            fileSelector.launch("image/*")
        }
    }
}