package com.example.ostabelya.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ostabelya.R;
import com.example.ostabelya.activities.CreateOrder;
import com.example.ostabelya.activities.DetailedPaymentRequest;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Order;
import com.example.ostabelya.models.Request;
import kotlin.Unit;

import java.util.List;

public class MyRequestsAdapter extends RecyclerView.Adapter<MyRequestsAdapter.ViewHolder> {
    List<Request> myRequests;

    public MyRequestsAdapter(List<Request> requests) {
        this.myRequests = requests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_request_item, viewGroup, false);

        return new MyRequestsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FirebaseUtils.Companion.getCustomerRequests((requests) ->{
            viewHolder.requestTime.setText("Request time: " + requests.get(i).requestDate
                    + "@ " + requests.get(i).requestSlot);
            FirebaseUtils.Companion.getMechanicByUid(myRequests.get(i).mid,(mechanic) ->{
                viewHolder.mechanicName.setText(mechanic.name);
                return Unit.INSTANCE;
            }, ()->{
                return Unit.INSTANCE;
            });
            return Unit.INSTANCE;
        }, ()->{
            return Unit.INSTANCE;
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return myRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mechanicName;
        public TextView requestTime;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            mechanicName = (TextView) itemView.findViewById(R.id.r_mechanic_name);
            requestTime = (TextView) itemView.findViewById(R.id.request_timing);

        }
    }
}
