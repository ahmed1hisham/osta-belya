package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Customer;
import kotlin.Unit;

public class CreateOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);


    }
}
