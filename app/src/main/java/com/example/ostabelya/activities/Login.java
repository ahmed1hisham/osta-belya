package com.example.ostabelya.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.firebase.FirebaseUtils;
import kotlin.Unit;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void onSignInPress(View v){
        EditText email = (EditText) findViewById(R.id.loginEmail);
        EditText pass = (EditText) findViewById(R.id.loginPassword);
        Intent intent = new Intent(Login.this, ListMechanics.class);
        Intent intentM = new Intent(Login.this, MechanicHome.class);
        FirebaseUtils.Companion.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString(), () -> {
            if(email.getText().toString().equals("amrahmed@gmail.com")){
                startActivity(intent);
            }else {
                startActivity(intentM);
            }

            finish();
            return Unit.INSTANCE;
        }, (message) -> {
            Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
            return Unit.INSTANCE;
        });
    }
}
