package com.example.ostabelya.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ostabelya.AcceptPayment.AuthTokenModel
import com.example.ostabelya.AcceptPayment.OrderResponse
import com.example.ostabelya.AcceptPayment.OrderUtils
import com.example.ostabelya.R
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            OrderUtils.requestAuthentication {
                val authToken = jacksonObjectMapper().readValue<AuthTokenModel>(it)
                OrderUtils.createOrderRequest(authToken.token, authToken.profile.id.toString(), "10000", 12345) {orderRequestJson ->
                    val orderResponse = jacksonObjectMapper().readValue<OrderResponse>(orderRequestJson)
                    runOnUiThread {
                        test.text = orderResponse.id.toString()
                    }
                }

            }

    }
}
