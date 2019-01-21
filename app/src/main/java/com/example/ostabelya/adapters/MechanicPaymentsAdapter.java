package com.example.ostabelya.adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ostabelya.R;
import com.example.ostabelya.models.Transaction;

import java.util.List;

public class MechanicPaymentsAdapter extends RecyclerView.Adapter<MechanicPaymentsAdapter.ViewHolder>{
@NonNull
List<Transaction> transactions;

    public MechanicPaymentsAdapter(@NonNull List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
public MechanicPaymentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.payment_item, viewGroup, false);

        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull MechanicPaymentsAdapter.ViewHolder viewHolder,int i){
            viewHolder.customerName.setText(transactions.get(i).userName);
            viewHolder.moneyAmount.setText(transactions.get(i).moneyAmount+"");
            viewHolder.date.setText(transactions.get(i).date);
        }

@Override
public int getItemCount(){
        return transactions.size();
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
