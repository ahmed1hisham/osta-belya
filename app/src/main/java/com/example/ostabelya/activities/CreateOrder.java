package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ostabelya.AcceptPayment.OrderUtils;
import com.example.ostabelya.R;
import com.example.ostabelya.firebase.FirebaseUtils;
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
        int orderId = ((int)(Math.random() * 10000));

        OrderUtils.Companion.requestAuthentication((authToken)-> {
            OrderUtils.Companion.createOrderRequest(authToken, "2652", (money * 1000) + "",orderId, (acceptOrderID)-> {
                OrderUtils.Companion.getPaymentKey(authToken, (money * 100) + "", acceptOrderID, "4029", (paymentToken) -> {
                    createOrderInFirebase(paymentToken, orderId+"", (money * 1000));

                    return Unit.INSTANCE;
                });
                return Unit.INSTANCE;
            });
            return Unit.INSTANCE;
        });
    }

    public void createOrderInFirebase(String paymentToken, String orderId, int money) {
        FirebaseUtils.Companion.getCurrentAuthMechanic((mid)->{
            Order order = new Order(orderId, mid, getIntent().getStringExtra("EXTRA_SESSION_ID"),paymentToken, money, new Date().toString());
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
