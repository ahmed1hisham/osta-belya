package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.ListMechanicsAdabtar;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Mechanic;
import kotlin.Unit;

import java.util.ArrayList;

public class ListMechanics extends AppCompatActivity {

    private ArrayList<Mechanic> mecha;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mechanics);

        recyclerView = (RecyclerView)findViewById(R.id.all_mechanics);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseUtils.Companion.getMechanics((mechanics) -> {
            this.mecha = mechanics;

            ListMechanicsAdabtar pickUpRequestItemAdapter = new ListMechanicsAdabtar(mecha);
            recyclerView.setAdapter(pickUpRequestItemAdapter);
            return Unit.INSTANCE;
        }, () -> {
            Toast.makeText(ListMechanics.this, "No Authenticated user", Toast.LENGTH_SHORT).show();
            return Unit.INSTANCE;
        });
    }
}