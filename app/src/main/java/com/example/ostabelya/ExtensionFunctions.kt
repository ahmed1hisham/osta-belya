package com.example.ostabelya

import android.content.Context
import android.widget.Toast

fun Context.toaster(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
