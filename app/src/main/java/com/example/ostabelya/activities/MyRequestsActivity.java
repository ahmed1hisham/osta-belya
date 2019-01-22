package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.MyRequestsAdapter;
import com.example.ostabelya.adapters.PaymentRequestAdapter;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Request;
import kotlin.Unit;

import java.util.ArrayList;

public class MyRequestsActivity extends AppCompatActivity {

    ArrayList<Request> myRequests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        RecyclerView paymentRequestsRecyclerView = (RecyclerView)findViewById(R.id.user_requests_recycler);
        paymentRequestsRecyclerView.setHasFixedSize(true);
        paymentRequestsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseUtils.Companion.getCustomerRequests((requests) -> {
            this.myRequests = requests;
            MyRequestsAdapter adapter = new MyRequestsAdapter(this.myRequests);
            paymentRequestsRecyclerView.setAdapter(adapter);
            return Unit.INSTANCE;
        }, ()->{
            return Unit.INSTANCE;
        });

    }
}
