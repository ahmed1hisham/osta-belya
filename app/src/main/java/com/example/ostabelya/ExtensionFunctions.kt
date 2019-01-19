package com.example.ostabelya

import android.content.Context
import android.widget.Toast

fun Context.toaster(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
