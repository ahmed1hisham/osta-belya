package com.example.ostabelya.adapters;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ostabelya.R;
import com.example.ostabelya.activities.CreateOrder;
import com.example.ostabelya.activities.MechanicSchedule;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Request;
import kotlin.Unit;

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
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context cont = v.getContext();
                    Intent intent = new Intent(cont, CreateOrder.class);
                    intent.putExtra("EXTRA_SESSION_ID", requests.get(i).uid);
                    cont.startActivity(intent);
                }
            });
    FirebaseUtils.Companion.getCustomerByUid(requests.get(i).uid, (cs)->{
        viewHolder.customerName.setText(cs.username);
        viewHolder.slot.setText(requests.get(i).requestSlot);
        return Unit.INSTANCE;
    }, () -> {
       return Unit.INSTANCE;
    });


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
