package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.MechanicPaymentsAdapter;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Payment;
import kotlin.Unit;

import java.util.ArrayList;

public class MechanicWalletActivity extends AppCompatActivity {
    private ArrayList<Payment> payments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_wallet);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mechanicPaymentsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseUtils.Companion.getMechanicPayments((payments) -> {
            this.payments = payments;
            MechanicPaymentsAdapter pickUpRequestItemAdapter = new MechanicPaymentsAdapter(this.payments);
            recyclerView.setAdapter(pickUpRequestItemAdapter);
            return Unit.INSTANCE;
        }, () -> {
            Toast.makeText(MechanicWalletActivity.this, "No Authenticated user", Toast.LENGTH_SHORT).show();
            return Unit.INSTANCE;
        });
    }
}
