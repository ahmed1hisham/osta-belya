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
import kotlin.Unit;

import java.util.List;

public class PaymentRequestAdapter extends RecyclerView.Adapter<PaymentRequestAdapter.ViewHolder> {
    List<Order> paymentRequests;

    public PaymentRequestAdapter(List<Order> paymentRequests) {
        this.paymentRequests = paymentRequests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.payment_request_item, viewGroup, false);

        return new PaymentRequestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FirebaseUtils.Companion.getMechanicByUid(paymentRequests.get(i).mid,(mechanic) ->{
            viewHolder.mechanicName.setText(mechanic.name);
            viewHolder.moneyAmount.setText(paymentRequests.get(i).moneyAmount+"");
            viewHolder.date.setText(paymentRequests.get(i).date);
            return Unit.INSTANCE;
        }, ()->{
            return Unit.INSTANCE;
        });



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context cont = v.getContext();
                Intent intent = new Intent(cont, DetailedPaymentRequest.class);
                intent.putExtra("MECHANIC_ID", paymentRequests.get(i).mid);
                intent.putExtra("MONEY", paymentRequests.get(i).moneyAmount);
                intent.putExtra("DATE", paymentRequests.get(i).date);
                cont.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paymentRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mechanicName;
        public TextView moneyAmount;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            mechanicName = (TextView) itemView.findViewById(R.id.paymentRequestMechanicName);
            moneyAmount = (TextView) itemView.findViewById(R.id.paymentRequestMoneyAmount);
            date = (TextView) itemView.findViewById(R.id.paymentRequestDate);

        }
    }
}
