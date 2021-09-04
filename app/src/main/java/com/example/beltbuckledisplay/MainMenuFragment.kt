package com.example.beltbuckledisplay

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.beltbuckledisplay.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {
    private var _binding: FragmentMainMenuBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var startButton: Button
    private lateinit var addFileButton: Button
    private val fileSelector = registerForActivityResult(
        ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToEditFileSettingsFragment(it.toString())
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startButton = binding.startButton
        startButton.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToDisplayModeFragment()
            it.findNavController().navigate(action)
        }

        addFileButton = view.findViewById(R.id.addFileButton)
        addFileButton.setOnClickListener {
            fileSelector.launch("image/*")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}