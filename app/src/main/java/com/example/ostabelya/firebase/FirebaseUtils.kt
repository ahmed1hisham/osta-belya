package com.example.ostabelya.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FirebaseUtils {

    companion object {
        val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
        val firebaseDatabase by lazy { FirebaseDatabase.getInstance() }

    }
}