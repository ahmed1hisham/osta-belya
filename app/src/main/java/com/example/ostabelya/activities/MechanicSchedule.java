package com.example.ostabelya.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.MechanicScheduleAdapter;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Request;
import kotlin.Unit;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MechanicSchedule extends AppCompatActivity {
    private ArrayList<Request> requests;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_schedule);


        TextView date = (TextView)findViewById(R.id.Mechdate);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date nowDate = new Date();
        date.setText(dateFormat.format(nowDate));
        recyclerView = (RecyclerView)findViewById(R.id.mechanicScheduleList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        update(date);

        Button inc = (Button)findViewById(R.id.incre);

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Date nowDate = new SimpleDateFormat("yyyy/MM/dd").parse(date.getText().toString());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(nowDate);
                    cal.add(Calendar.DATE, 1);
                    date.setText(dateFormat.format(cal.getTime()));
                    update(date);

                }catch (Exception e){

                }

            }
        });

        Button dec = (Button)findViewById(R.id.decre);

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Date nowDate = new SimpleDateFormat("yyyy/MM/dd").parse(date.getText().toString());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(nowDate);
                    cal.add(Calendar.DATE, -1);
                    date.setText(dateFormat.format(cal.getTime()));
                    update(date);
                }catch (Exception e){

                }

            }
        });
    }

    private void update(TextView date){
        FirebaseUtils.Companion.getMerchantRequests((requests) -> {
            this.requests = requests;
            ArrayList<Request> result = new ArrayList<Request>();
            for(Request rq: requests){
                if(rq.requestDate.equals(date.getText()))
                    result.add(rq);
            }
            MechanicScheduleAdapter pickUpRequestItemAdapter = new MechanicScheduleAdapter(result);
            recyclerView.setAdapter(pickUpRequestItemAdapter);
            return Unit.INSTANCE;
        }, () -> {
            Toast.makeText(MechanicSchedule.this, "No Authenticated user", Toast.LENGTH_SHORT).show();
            return Unit.INSTANCE;
        });
    }
}




