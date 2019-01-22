package com.example.ostabelya.firebase

import com.example.ostabelya.models.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*


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
        fun createUserInDatabase(user: Customer,
                                 onSuccess: () -> Unit,
                                 onFailure: (errorMessage: String) -> Unit) {
            firebaseDatabase.reference.child("customer")
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

            firebaseDatabase.reference.child("mechanic").child(firebaseAuth.currentUser!!.uid).child("requests")
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
            firebaseDatabase.reference.child("mechanic").child(firebaseAuth.currentUser!!.uid).child("transactions")
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

        fun getCustomerByUid (uid: String,onSuccess: (Customer) -> Unit, onFailure: () -> Unit){
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

        fun getMechanicByUid (mid: String, onSuccess: (Mechanic) -> Unit, onFailure: () -> Unit){
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


        fun addOrderToMechanic(order: Order, onSuccess: () -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child("mechanic")
                .child(firebaseAuth.currentUser!!.uid)
                .child("orders").child(order.orderID).setValue(order)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onSuccess()
                    } else if (!it.isSuccessful) {
                        onFailure()
                    }
                }
        }

        fun addPaymentRequestToCustomer(order: Order,uid: String, onSuccess: () -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child("customer").child(uid).child("paymentRequests").child(order.orderID)
                .setValue(order).addOnCompleteListener {
                    if (it.isSuccessful) {
                        onSuccess()
                    } else if (!it.isSuccessful) {
                        onFailure()
                    }
                }
        }

        fun getCurrentAuthMechanic(onSuccess: (String) -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child(firebaseAuth.currentUser!!.uid).addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    onFailure()
                }

                override fun onDataChange(p0: DataSnapshot) {
                    onSuccess(firebaseAuth.currentUser!!.uid);
                }

            })
        }


        fun getMechanicWorkers(onSuccess: (ArrayList<Worker>) -> Unit, onFailure: () -> Unit) {

            firebaseDatabase.reference.child("mechanic").child(firebaseAuth.currentUser!!.uid).child("workers")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        onFailure()
                    }
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val workers = ArrayList<Worker>();
                        //println("Ay 7AGA " + dataSnapshot.getValue())
                        for (req in dataSnapshot.children){
                            //println("Ay 7aga" + req.getValue())
                            workers.add(req.getValue(Worker::class.java)!!)
                        }
                    onSuccess(workers)
                    }
                })
        }

        fun getMechanics(onSuccess: (ArrayList<Mechanic>) -> Unit, onFailure: () -> Unit) {

            firebaseDatabase.reference.child("mechanic")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        onFailure()
                    }
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val mechanics = ArrayList<Mechanic>();
                        for (mecha in dataSnapshot.children){
                            mechanics.add(mecha.getValue(Mechanic::class.java)!!);
                        }
                        onSuccess(mechanics)
                    }
                })
        }

        fun getCustomerPaymentRequests(onSuccess: (ArrayList<Order>) -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child("customer").child(firebaseAuth.currentUser!!.uid).child("paymentRequests")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val paymentRequests = ArrayList<Order>();
                        for (req in dataSnapshot.children){
                            paymentRequests.add(req.getValue(Order::class.java)!!)
                        }
                        onSuccess(paymentRequests)
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        onFailure()
                    }

                })
        }
    //firebaseAuth.currentUser!!.uid
        fun addRequestToMechanic(request: Request, onSuccess: () -> Unit, onFailure: () -> Unit){
            firebaseDatabase.reference.child("mechanic")
                .child(request.mid)
                .child("requests").child(UUID.randomUUID().toString()).setValue(request)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onSuccess()
                    } else if (!it.isSuccessful) {
                        onFailure()
                    }
                }
        }




    }
}