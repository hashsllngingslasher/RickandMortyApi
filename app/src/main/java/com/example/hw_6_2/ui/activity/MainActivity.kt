package com.example.hw_6_2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_6_2.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}