package com.example.hw_6_2.extension

import android.widget.ImageView
import com.example.hw_6_2.R

fun ImageView.setIndicator(status: String) {
    setImageResource(
        when (status) {
            "Alive" -> R.drawable.ic_dot_green
            "Dead" -> R.drawable.ic_dot_red
            else -> R.drawable.ic_dot_grey
        }
    )
}