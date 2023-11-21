package com.example.androiduiexperiments.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androiduiexperiments.R
import com.example.androiduiexperiments.databinding.FragmentDashboardBinding
import com.google.android.material.snackbar.Snackbar
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageSwitcher


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val images = intArrayOf(R.drawable.red_binary_cpu,
        R.drawable.scifi_tank, R.drawable.poitou_walls)

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

        //access the image switcher
        val imgSwitcher = view.findViewById<ImageSwitcher>(R.id.imageView)
        imgSwitcher?.setFactory({
            val imgView = ImageView(activity)
            imgView.scaleType = ImageView.ScaleType.FIT_XY
            imgView.setPadding(8, 8, 8, 8)
            imgView
        })

        //set the default image
        imgSwitcher.setImageResource(images[0])

        //set the 2 animations for in and out
        val inAnim = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left)
        imgSwitcher.inAnimation = inAnim
        val out = AnimationUtils.loadAnimation(activity, android.R.anim.fade_out)
        imgSwitcher.outAnimation = out

        //set up code to listen for the various butten presses
        binding.computerButton.setOnClickListener { view ->
            Snackbar.make(view, "Put in the computer image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //imageView.setImageResource(R.drawable.red_binary_cpu)
            imgSwitcher.setImageResource(images[0])
        }
        binding.tankButton.setOnClickListener { view ->
            Snackbar.make(view, "Put in the tank image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //imageView.setImageResource(R.drawable.scifi_tank)
            imgSwitcher.setImageResource(images[1])
        }
        binding.castleButton.setOnClickListener { view ->
            Snackbar.make(view, "Put in the castle image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //imageView.setImageResource(R.drawable.poitou_walls)
            imgSwitcher.setImageResource(images[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
