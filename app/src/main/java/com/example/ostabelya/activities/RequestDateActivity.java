package com.example.ostabelya.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.ostabelya.R;
import com.example.ostabelya.adapters.MechanicPaymentsAdapter;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Request;
import com.google.firebase.auth.FirebaseAuth;
import kotlin.Unit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RequestDateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    TextView dtResult;
    Button btnPick;
    String dateFinalString;
    Request request = new Request();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_date);
        //Intent intent = getIntent();
        //String mid = intent.getStringExtra("mid");
        request.mid = "321";
        request.uid = "123";
        request.status = "Pending";
//        FirebaseUtils.Companion.getCurrentAuthMechanic((uid) -> {
//            this.request.uid = uid;
//            return Unit.INSTANCE;
//        }, () -> {
//            return Unit.INSTANCE;
//        });

        btnPick = (Button)findViewById(R.id.btn_picker);
        dtResult = (TextView) findViewById(R.id.date_time);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestDateActivity.this,
                        RequestDateActivity.this, year, month, day);
                datePickerDialog.show();

            }
        });

    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;
        System.out.println(i1);
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(RequestDateActivity.this,
                RequestDateActivity.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;
        String dayFinalString;
        String monthFinalString;
        if(dayFinal<=9){
            dayFinalString = "0" + dayFinal;
        }
        else {
            dayFinalString = dayFinal + "";
        }
        if(monthFinal<=9){
            monthFinalString = "0" + monthFinal;
        }
        else {
            monthFinalString = monthFinal + "";
        }

        String date = "" + yearFinal + "/" + monthFinalString + "/" + dayFinalString;
        Date dateFinal = new Date();
        try {
            dateFinal =new SimpleDateFormat("yyyy/MM/dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateFinalString = dateFinal.toString();
        //dtResult.setText(date + " @ " + hourFinal + ":" + minuteFinal);
        request.requestDate = dateFinalString;
        String hourFinalString;
        String minuteFinalString;
        if(hourFinal<=9){
            hourFinalString = "0" + hourFinal;
        }
        else {
            hourFinalString = "" + minuteFinal;
        }
        if(minuteFinal<=9){
            minuteFinalString = "0" + minuteFinal;
        }
        else {
            minuteFinalString = "" + minuteFinal;
        }
        request.requestSlot = hourFinalString+":"+minuteFinalString;
        dtResult.setText(date + " @ " + hourFinalString + ":" + minuteFinalString);
    }
}
