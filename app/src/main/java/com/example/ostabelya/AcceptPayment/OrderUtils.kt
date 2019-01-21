package com.example.ostabelya.AcceptPayment

import android.util.Log
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
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
                    val authTokenResponse = jacksonObjectMapper().readValue<AuthTokenModel>(authTokenJson)
                    onResponse(authTokenResponse.token)
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

            val orderRequestAsJson = jacksonObjectMapper().writeValueAsString(orderRequest)
            Log.e("orderRequestJson", orderRequestAsJson)

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
                    val orderResponse = jacksonObjectMapper().readValue<OrderResponse>(orderResponseJson)
                    Log.e("orderResponseJson", orderResponseJson)
                    onResponse(orderResponse.id.toString())
                }
            })
        }

        fun getPaymentKey(authToken: String, amount: String, orderId: String, walletId: String, onResponse: (paymentKeyResponseAsJson: String) -> Unit) {
            val getPaymentKeyJson = "{\n" +
                    "  \"auth_token\": \"$authToken\", \n" +
                    "  \"amount_cents\": \"$amount\", \n" +
                    "  \"expiration\": 36000, \n" +
                    "  \"order_id\": \"$orderId\",   \n" +
                    "  \"currency\": \"EGP\", \n" +
                    "  \"integration_id\": $walletId ,\n" +
                    "  \"lock_order_when_paid\": \"false\" ,\n" +
                    "\t\"billing_data\": {\n" +
                    "    \"apartment\": \"NA\", \n" +
                    "    \"email\": \"mohd.hussayn@gmail.com\", \n" +
                    "    \"floor\": \"NA\", \n" +
                    "    \"first_name\": \"Mohamed\", \n" +
                    "    \"street\": \"NA\", \n" +
                    "    \"building\": \"NA\", \n" +
                    "    \"phone_number\": \"+201123666937\", \n" +
                    "    \"shipping_method\": \"NA\", \n" +
                    "    \"postal_code\": \"NA\", \n" +
                    "    \"city\": \"Cairo\", \n" +
                    "    \"country\": \"NA\", \n" +
                    "    \"last_name\": \"Hussein\", \n" +
                    "    \"state\": \"NA\"\n" +
                    "  }\n" +
                    "}"


            val body = RequestBody.create(JSON, getPaymentKeyJson)
            val request = Request.Builder()
                .url("https://accept.paymobsolutions.com/api/acceptance/payment_keys")
                .post(body)
                .build()

            client.newCall(request).enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {}

                override fun onResponse(call: Call, response: Response) {
                    val paymentKeyResponseJson = response.body()!!.string()
                    val paymentKeyResponse = jacksonObjectMapper().readValue<PaymentKeyResponse>(paymentKeyResponseJson)
                    onResponse(paymentKeyResponse.token)
                }
            })
        }
    }
}