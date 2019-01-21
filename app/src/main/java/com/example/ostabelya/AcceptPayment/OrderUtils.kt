package com.example.ostabelya.AcceptPayment

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.*
import java.io.IOException

class OrderUtils{
    companion object {
        private val JSON = MediaType.get("application/json; charset=utf-8")
        private val API_KEY =
            "ZXlKaGJHY2lPaUpJVXpVeE1pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SnVZVzFsSWpvaWFXNXBkR2xoYkNJc0ltTnNZWE56SWpvaVRXVnlZMmhoYm5RaUxDSndjbTltYVd4bFgzQnJJam95TmpVeWZRLi12YS1NazRNMjdsRU9fTjlNOGRmOXItOHdqcmFZaVZuamhib3VzRGE4dzU5akptU2dUM3ZxNEZ1Wkl0cGNmZGhGVVNvUHdzWFl4U2tzUGcxMy1kdU9B"
        private var client = OkHttpClient()

        fun requestAuthentication(onResponse: (authToken: String) -> Unit) {
            val json = "{\n" +
                    "  \"api_key\": \"$API_KEY\"\n" +
                    "}"

            val body = RequestBody.create(JSON, json)
            val request = Request.Builder()
                .url("https://accept.paymobsolutions.com/api/auth/tokens")
                .post(body)
                .build()

            client.newCall(request).enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val authTokenJson = response.body()!!.string()
                    onResponse(authTokenJson)
                }
            })
        }

        fun createOrderRequest(authToken: String, merchantId: String, amount: String, merchantOrderId: Int,
                               onResponse: (orderId: String) -> Unit) {
            val orderRequest = OrderRequest()
            orderRequest.authToken = authToken
            orderRequest.merchantId = merchantId
            orderRequest.amountCents = amount
            orderRequest.merchantOrderId = merchantOrderId

            val orderRequestAsJson = jacksonObjectMapper().writeValueAsBytes(orderRequest)

            val body = RequestBody.create(JSON, orderRequestAsJson)
            val request = Request.Builder()
                .url("https://accept.paymobsolutions.com/api/ecommerce/orders")
                .post(body)
                .build()

            client.newCall(request).enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val orderResponseJson = response.body()!!.string()
                    onResponse(orderResponseJson)
                }
            })
        }
    }
}