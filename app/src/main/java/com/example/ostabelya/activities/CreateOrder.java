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
import java.util.UUID;

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
            String uid = getIntent().getStringExtra("EXTRA_SESSION_ID");
            Order order = new Order(UUID.randomUUID().toString(), mid, uid, token, money, orderDate.toString());

            FirebaseUtils.Companion.addOrderToMechanic(order,() -> {
                Toast.makeText(CreateOrder.this, "Order Added", Toast.LENGTH_SHORT).show();
                return Unit.INSTANCE;
            }, () ->{
                Toast.makeText(CreateOrder.this, "Try Again", Toast.LENGTH_SHORT).show();
                return Unit.INSTANCE;
            });

            FirebaseUtils.Companion.addPaymentRequestToCustomer(order,uid, ()->{
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
