package com.example.ostabelya.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.ostabelya.R
import com.example.ostabelya.adapters.EmalaAdapter
import com.example.ostabelya.adapters.MechanicPaymentsAdapter
import com.example.ostabelya.firebase.FirebaseUtils
import com.example.ostabelya.models.Transaction
import com.example.ostabelya.models.Worker
import com.example.ostabelya.toaster
import kotlinx.android.synthetic.main.activity_emala.*
import java.util.ArrayList

class EmalaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emala)

        var workers = arrayListOf<Worker>()
        FirebaseUtils.getMechanicWorkers({ response ->
            workers = response!!
            Unit
        }, {
            toaster("No Authenticated user", Toast.LENGTH_SHORT)
            Unit
        })

        recycler_view.apply {
            layoutManager = GridLayoutManager(this@EmalaActivity, 2)
            adapter = EmalaAdapter(workers)
        }

    }
}
