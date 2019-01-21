package com.example.ostabelya.adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ostabelya.R;
import com.example.ostabelya.models.Payment;

import java.util.ArrayList;
import java.util.List;

public class MechanicPaymentsAdapter extends RecyclerView.Adapter<MechanicPaymentsAdapter.ViewHolder>{
@NonNull
List<Payment> payments;

@Override
public MechanicPaymentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        return null;
        }

@Override
public void onBindViewHolder(@NonNull MechanicPaymentsAdapter.ViewHolder viewHolder,int i){

        }

@Override
public int getItemCount(){
        return payments.size();
        }


public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView customerName;
    public TextView moneyAmount;
    public TextView date;

    public ViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.paymentItemImage);
        customerName = (TextView) itemView.findViewById(R.id.paymentItemCustomerName);
        moneyAmount = (TextView) itemView.findViewById(R.id.paymentItemMoneyAmount);
        date = (TextView) itemView.findViewById(R.id.paymentItemDate);

    }
}
}
