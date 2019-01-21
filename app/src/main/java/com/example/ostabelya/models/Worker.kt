package com.example.ostabelya.models

data class Worker (val name: String,
                   val accountNumber: Int,
                   val username: String = "",
                   val imgURL: String = "",
                   val salary: Int
)