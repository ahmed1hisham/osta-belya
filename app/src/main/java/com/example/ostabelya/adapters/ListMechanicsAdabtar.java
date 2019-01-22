package com.example.ostabelya.adapters;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.ostabelya.ExtensionFunctionsKt;
import com.example.ostabelya.R;
import com.example.ostabelya.activities.CreateOrder;
import com.example.ostabelya.activities.ListMechanics;
import com.example.ostabelya.activities.RequestDateActivity;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Mechanic;
import com.example.ostabelya.models.Request;
import kotlin.Unit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListMechanicsAdabtar extends RecyclerView.Adapter<ListMechanicsAdabtar.ViewHolder> implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener{
@NonNull
List<Mechanic> mechanics;
    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    Context cont;
    String dateFinalString;
    Request request = new Request();

    public ListMechanicsAdabtar(@NonNull List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    @Override
public ListMechanicsAdabtar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mechanic_item, viewGroup, false);


        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ListMechanicsAdabtar.ViewHolder viewHolder, int i){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cont = v.getContext();
                    Calendar c = Calendar.getInstance();
                    year = c.get(Calendar.YEAR);
                    month = c.get(Calendar.MONTH);
                    day = c.get(Calendar.DAY_OF_MONTH);
                    request.status = "Pending";
                    request.mid = mechanics.get(i).mid;
                    request.uid = "123";
                    DatePickerDialog datePickerDialog = new DatePickerDialog(cont,
                            ListMechanicsAdabtar.this::onDateSet, year, month, day);
                    datePickerDialog.show();
                }
            });

            viewHolder.location.setText(mechanics.get(i).location);
            viewHolder.categoryy.setText(mechanics.get(i).categoryy+"");
            viewHolder.description.setText(mechanics.get(i).description);
            viewHolder.name.setText(mechanics.get(i).name);
            viewHolder.rating.setText(mechanics.get(i).rating+"");
            viewHolder.waitingTime.setText(mechanics.get(i).waitingTime+"");

        }

@Override
public int getItemCount(){
        return mechanics.size();
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

        TimePickerDialog timePickerDialog = new TimePickerDialog(cont,
                ListMechanicsAdabtar.this, hour, minute, DateFormat.is24HourFormat(cont));
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
        request.requestDate = date;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(cont);
        builder.setCancelable(true);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to book at this time?"
                + System.lineSeparator() + date + " @ " + hourFinalString + ":" + minuteFinalString
                + System.lineSeparator() + "You will be the 3rd in the queue"
        );
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //FireBase Function
                        FirebaseUtils.Companion.addRequestToMechanic(request,() -> {
                            ExtensionFunctionsKt.toaster(cont,
                                    "Request sent successfully", Toast.LENGTH_SHORT);
                            return Unit.INSTANCE;
                        }, () ->{
                            Toast.makeText(cont, "Please try again", Toast.LENGTH_SHORT).show();
                            return Unit.INSTANCE;
                        });

                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ExtensionFunctionsKt.toaster(cont,
                        "Request cancelled", Toast.LENGTH_SHORT);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView name;
    public TextView description;
    public TextView rating;
    public TextView waitingTime;
    public TextView categoryy;
    public TextView location;

    public ViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.mer_image);
        name = (TextView) itemView.findViewById(R.id.mer_name);
        description = (TextView) itemView.findViewById(R.id.mer_description);
        rating = (TextView) itemView.findViewById(R.id.mer_rating);
        waitingTime = (TextView) itemView.findViewById(R.id.mer_waiting);
        categoryy = (TextView) itemView.findViewById(R.id.mer_category);
        location = (TextView) itemView.findViewById(R.id.mer_location);



    }
}
}
