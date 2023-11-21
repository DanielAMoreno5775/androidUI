package com.example.androiduiexperiments.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androiduiexperiments.databinding.FragmentSettingsBinding
import com.example.androiduiexperiments.R
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.Objects

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val modeSwitcherBtn = view.findViewById<SwitchMaterial>(R.id.switchBtn)
        modeSwitcherBtn.setText("Light Mode")

        modeSwitcherBtn?.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked) modeSwitcherBtn.setText("Night Mode")
            else modeSwitcherBtn.setText("Light Mode")
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}