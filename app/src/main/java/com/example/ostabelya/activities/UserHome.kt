package com.example.ostabelya.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ostabelya.R

class UserHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
    }

    fun mechanicsPressed(view: View) {
        startActivity(Intent(this, ListMechanics::class.java))
    }

    fun requestsPressed(view: View) {
        startActivity(Intent(this, MyRequestsActivity::class.java))
    }

    fun payRequestsPressed(view: View) {
        startActivity(Intent(this, PaymentRequests::class.java))
    }
}
