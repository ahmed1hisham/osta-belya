package com.example.ostabelya.adapters;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ostabelya.R;
import com.example.ostabelya.activities.CreateOrder;
import com.example.ostabelya.firebase.FirebaseUtils;
import com.example.ostabelya.models.Mechanic;
import com.example.ostabelya.models.Request;
import kotlin.Unit;

import java.util.List;

public class ListMechanicsAdabtar extends RecyclerView.Adapter<ListMechanicsAdabtar.ViewHolder>{
@NonNull
List<Mechanic> mechanics;


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
                    Context cont = v.getContext();
                    Intent intent = new Intent(cont, CreateOrder.class);
                    intent.putExtra("mid", mechanics.get(i).mid);
                    cont.startActivity(intent);
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
