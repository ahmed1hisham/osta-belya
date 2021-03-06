package com.example.ostabelya.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.ostabelya.AcceptPayment.OrderUtils;
import com.example.ostabelya.R;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.google.firebase.database.FirebaseDatabase;
import kotlin.Unit;

public class DetailedPaymentRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_payment_request);
        TextView mechanicName = findViewById(R.id.detailedPaymentRequestMechanicName);
        TextView moneyAmount = findViewById(R.id.detailedPaymentRequestMoneyAmount);
        Button payBtn = findViewById(R.id.detailedPaymentRequestPayButton);
        TextView date = findViewById(R.id.detailedPaymentRequestDate);
        String midRet = getIntent().getStringExtra("MECHANIC_ID");
        int moneyRet = getIntent().getIntExtra("MONEY",0);
        String dateRet = getIntent().getStringExtra("DATE");

        FirebaseUtils.Companion.getMechanicByUid(midRet, (mechanic) ->{
            mechanicName.setText(mechanic.name);
            moneyAmount.setText(moneyRet+"");
            date.setText(dateRet);
            return Unit.INSTANCE;
        }, ()->{
            return Unit.INSTANCE;
        });

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paymentToken = getIntent().getStringExtra("token");
                OrderUtils.Companion.payOrder(paymentToken, (redirectUrl) -> {
                    Log.e("url", redirectUrl);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(redirectUrl));
                    startActivity(i);
                    return Unit.INSTANCE;
                });
            }
        });
    }
}
