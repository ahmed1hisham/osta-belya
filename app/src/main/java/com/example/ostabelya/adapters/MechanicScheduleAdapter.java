package com.example.ostabelya.adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ostabelya.R;
import com.example.ostabelya.models.Request;

import java.util.List;

public class MechanicScheduleAdapter extends RecyclerView.Adapter<MechanicScheduleAdapter.ViewHolder>{
@NonNull
List<Request> requests;

    public MechanicScheduleAdapter(@NonNull List<Request> requests) {
        this.requests = requests;
    }

    @Override
public MechanicScheduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.schedule_item, viewGroup, false);

        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull MechanicScheduleAdapter.ViewHolder viewHolder, int i){
            viewHolder.customerName.setText(requests.get(i).uid + "");
            viewHolder.slot.setText(requests.get(i).requestSlot);

        }

@Override
public int getItemCount(){
        return requests.size();
        }


public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView customerName;
    public TextView slot;

    public ViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.customerItemImage);
        customerName = (TextView) itemView.findViewById(R.id.scheduleItemCustomerName);
        slot = (TextView) itemView.findViewById(R.id.scheduleItemSlot);


    }
}
}