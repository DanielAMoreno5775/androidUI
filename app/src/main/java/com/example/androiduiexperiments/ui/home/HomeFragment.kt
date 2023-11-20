package com.example.androiduiexperiments.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androiduiexperiments.SliderAdapter
import com.example.androiduiexperiments.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView
import com.example.androiduiexperiments.R


class HomeFragment : Fragment() {

    lateinit var imageUrl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //sets up the automatic image slider
        sliderView = view.findViewById(R.id.imageCarouselId)
        imageUrl = ArrayList()

        imageUrl =
            (imageUrl + "https://static.wixstatic.com/media/650d4c_f977c92224bb4afea765aa6c3237aa5c~mv2.png") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://static.wixstatic.com/media/650d4c_c9cf32343eed448ebb85c5674b95e04b~mv2.png") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://static.wixstatic.com/media/650d4c_8d906744db9d406ba910138f983cc89c~mv2.png") as ArrayList<String>

        sliderAdapter = SliderAdapter( imageUrl)

        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        sliderView.setSliderAdapter(sliderAdapter)

        sliderView.scrollTimeInSec = 3

        sliderView.isAutoCycle = true

        sliderView.startAutoCycle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}