package com.example.androiduiexperiments.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androiduiexperiments.R
import com.example.androiduiexperiments.databinding.FragmentDashboardBinding
import com.google.android.material.snackbar.Snackbar


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById(R.id.imageView) as ImageView
        imageView.setImageResource(R.drawable.poitou_walls)

        binding.computerButton.setOnClickListener { view ->
            Snackbar.make(view, "Put in the computer image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            imageView.setImageResource(R.drawable.red_binary_cpu)
        }
        binding.tankButton.setOnClickListener { view ->
            Snackbar.make(view, "Put in the tank image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            imageView.setImageResource(R.drawable.scifi_tank)
        }
        binding.castleButton.setOnClickListener { view ->
            Snackbar.make(view, "Put in the castle image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            imageView.setImageResource(R.drawable.poitou_walls)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}