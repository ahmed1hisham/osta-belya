package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.MechanicScheduleAdapter;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Request;
import kotlin.Unit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MechanicSchedule extends AppCompatActivity {
    private ArrayList<Request> requests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_schedule);
        TextView date = (TextView)findViewById(R.id.Mechdate);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date nowDate = new Date();
        date.setText(dateFormat.format(nowDate));
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mechanicScheduleList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseUtils.Companion.getMerchantRequests((requests) -> {
            this.requests = requests;
            MechanicScheduleAdapter pickUpRequestItemAdapter = new MechanicScheduleAdapter(this.requests);
            recyclerView.setAdapter(pickUpRequestItemAdapter);
            return Unit.INSTANCE;
        }, () -> {
            Toast.makeText(MechanicSchedule.this, "No Authenticated user", Toast.LENGTH_SHORT).show();
            return Unit.INSTANCE;
        });
    }
}




