package com.example.ostabelya.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.ostabelya.R
import com.example.ostabelya.adapters.EmalaAdapter
import com.example.ostabelya.models.Worker
import kotlinx.android.synthetic.main.activity_emala.*

class EmalaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emala)

        val workers = arrayListOf<Worker>()

        for (i in 1..100) {
            workers.add(Worker("محمد جمال", 2012565583, "", "", 100))
        }

        recycler_view.apply {
            layoutManager = GridLayoutManager(this@EmalaActivity, 2)
            adapter = EmalaAdapter(workers)
        }

    }
}
