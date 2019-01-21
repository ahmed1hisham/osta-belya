package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Customer;
import com.example.ostabelya.models.Order;
import kotlin.Unit;

import java.util.Date;

public class CreateOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
    }

    public void confirmOrderPressed(View createOrderView){
        TextView moneyAmount = findViewById(R.id.orderMoneyAmount);
        int money = Integer.parseInt(moneyAmount.getText().toString());
        Date orderDate = new Date();
        String token = "Token ya HUSSIEEN";
        FirebaseUtils.Companion.getCurrentAuthMechanic((mid)->{
            Order order = new Order("hsbhds", mid, getIntent().getIntExtra("EXTRA_SESSION_ID",0),token, money, orderDate.toString());
            FirebaseUtils.Companion.addOrderToMechanic(order,() -> {
                Toast.makeText(CreateOrder.this, "Order Added", Toast.LENGTH_SHORT).show();
                return Unit.INSTANCE;
            }, () ->{
                Toast.makeText(CreateOrder.this, "Try Again", Toast.LENGTH_SHORT).show();
                return Unit.INSTANCE;
            });

            return Unit.INSTANCE;
        }, ()->{
            Toast.makeText(CreateOrder.this, "Try Again", Toast.LENGTH_SHORT).show();
            return Unit.INSTANCE;
        });



    }
}
