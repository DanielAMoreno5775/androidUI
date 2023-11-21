package com.example.androiduiexperiments.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the home fragment. Look below to see an auto-carousel of the 3 images used for this project."
    }
    val text: LiveData<String> = _text
}