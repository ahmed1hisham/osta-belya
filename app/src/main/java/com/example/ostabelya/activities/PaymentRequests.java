package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.PaymentRequestAdapter;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Order;
import kotlin.Unit;

import java.util.ArrayList;

public class PaymentRequests extends AppCompatActivity {
    ArrayList<Order> paymentRequests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_requests);


        RecyclerView paymentRequestsRecyclerView = (RecyclerView)findViewById(R.id.paymentRequestsRecyclerView);
        paymentRequestsRecyclerView.setHasFixedSize(true);
        paymentRequestsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseUtils.Companion.getCustomerPaymentRequests((paymentRequests) -> {
            this.paymentRequests = paymentRequests;
            PaymentRequestAdapter adapter = new PaymentRequestAdapter(this.paymentRequests);
            paymentRequestsRecyclerView.setAdapter(adapter);
            return Unit.INSTANCE;
        }, ()->{
            return Unit.INSTANCE;
        });

    }



}
