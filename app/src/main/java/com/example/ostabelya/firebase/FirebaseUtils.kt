package com.example.ostabelya.firebase

import com.example.ostabelya.models.Customer
import com.example.ostabelya.models.Mechanic
import com.example.ostabelya.models.Transaction
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
            firebaseDatabase.reference.child("mechanic")
                .child(user.mid.toString()).setValue(user)
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

            firebaseDatabase.reference.child("mechanic").child("100").child("requests")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        onFailure()
                    }
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val requests = ArrayList<Request>();
                        for (req in dataSnapshot.children){
                            requests.add(req.getValue(Request::class.java)!!);
                        }
                        onSuccess(requests)
                    }
                })
        }

        fun getMechanicPayments(onSuccess: (ArrayList<Transaction>) -> Unit, onFailure: () -> Unit) {
            firebaseDatabase.reference.child("mechanic").child("100").child("transactions")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        onFailure()
                    }
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val payments = ArrayList<Transaction>();
                        for (payment in dataSnapshot.children){
                            //println(payment.getValue())
                            payments.add(payment.getValue(Transaction::class.java)!!);
                        }
                        onSuccess(payments)
                    }
                })
        }

        fun getCustomerByUid (uid: Int,onSuccess: (Customer) -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child("customer").addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    onFailure()
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (customer in dataSnapshot.children){
                        if(customer.key!!.equals(uid)){
                            onSuccess(customer.getValue(Customer::class.java)!!);
                        }
                    }

                }
            })
        }

        fun getMechanicByUid (mid: Int,onSuccess: (Mechanic) -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child("mechanic").addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    onFailure()
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (customer in dataSnapshot.children){
                        if(customer.key!!.equals(mid)){
                            onSuccess(customer.getValue(Mechanic::class.java)!!);
                        }
                    }

                }
            })
        }


    }
}