package com.example.ostabelya.AcceptPayment

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthTokenModel(val token: String, val profile: Profile)