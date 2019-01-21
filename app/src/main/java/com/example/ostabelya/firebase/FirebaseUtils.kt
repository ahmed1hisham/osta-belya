package com.example.ostabelya.firebase

import com.example.ostabelya.models.Mechanic
import com.example.ostabelya.models.Request
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FirebaseUtils {

    companion object {
        val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
        val firebaseDatabase by lazy { FirebaseDatabase.getInstance() }

        fun signUpWithEmailAndPassword(email: String, password: String,
                                       onSuccess: () -> Unit,
                                       onFailure: (errorMessage: String) -> Unit) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onSuccess()
                    } else if (!it.isSuccessful) {
                        onFailure(it.exception!!.localizedMessage)
                    }
                }
        }

        fun createMerchantInDatabase(user: Mechanic,
                                 onSuccess: () -> Unit,
                                 onFailure: (errorMessage: String) -> Unit) {
            firebaseDatabase.reference.child("users")
                .child(user.uid).setValue(user)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onSuccess()
                    } else if (!it.isSuccessful) {
                        onFailure(it.exception!!.localizedMessage)
                    }
                }
        }

        fun signInWithEmailAndPassword(email: String, password: String,
                                       onSuccess: () -> Unit,
                                       onFailure: (errorMessage: String) -> Unit) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onSuccess()
                    } else if (!it.isSuccessful) {
                        onFailure(it.exception!!.localizedMessage)
                    }
                }
        }

        fun getMerchantRequests(onSuccess: (ArrayList<Request>) -> Unit, onFailure: () -> Unit) {

            firebaseDatabase.reference.child("request").child(firebaseAuth.currentUser!!.uid).child("requests")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        onFailure()
                    }
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val pickUpRequests = arrayListOf<PickupRequest>();
                        for (request in dataSnapshot.children){
                            pickUpRequests.add(request.getValue(PickupRequest::class.java)!!);
                        }
                        onSuccess(pickUpRequests)
                    }
                })
        }

    }
}