package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.ostabelya.R;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Customer;
import com.example.ostabelya.models.Mechanic;
import kotlin.Unit;

public class redundant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redundant);

//        FirebaseUtils.Companion.signUpWithEmailAndPassword("ahmedrihan@gmail.com", "aa12345", () ->{
//            Log.d("saksan", "onCreate: ");
//            String uid = FirebaseUtils.Companion.getFirebaseAuth().getCurrentUser().getUid();
//
//            FirebaseUtils.Companion.createMerchantInDatabase(new Mechanic(uid,0,"","Zaki",26, "Tagmo3", 767.3, 0, 16, 1),
//                    ()->{
//                return Unit.INSTANCE;
//
//            },(error)-> {
//                return Unit.INSTANCE;
//
//            });
//            return Unit.INSTANCE;
//        }, (error) ->{
//            Log.d("saksan", "onCreatessdnvdsgjacgvchdsa: ");
//            return Unit.INSTANCE;
//        });

        FirebaseUtils.Companion.signUpWithEmailAndPassword("amrahmed@gmail.com", "aa12345", () ->{
            String uid = FirebaseUtils.Companion.getFirebaseAuth().getCurrentUser().getUid();
            FirebaseUtils.Companion.createUserInDatabase(new Customer(uid,"Amr", 26, 0, "01992731991"),
                    ()->{
                        return Unit.INSTANCE;

                    },(error)-> {
                        return Unit.INSTANCE;

                    });
            return Unit.INSTANCE;
        }, (error) ->{

            return Unit.INSTANCE;
        });
    }

}
