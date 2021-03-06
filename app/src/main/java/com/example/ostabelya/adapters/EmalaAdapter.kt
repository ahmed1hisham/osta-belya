package com.example.ostabelya.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ostabelya.R
import com.example.ostabelya.models.Worker
import android.content.DialogInterface
import android.content.Intent
import com.example.ostabelya.activities.CreateOrder


class EmalaAdapter(val workers: ArrayList<Worker>) : RecyclerView.Adapter<EmalaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.worker_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = workers.size

    override fun onBindViewHolder(holder: EmalaAdapter.ViewHolder, position: Int) {
        //picasso to show the image?
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val cont = v!!.getContext()
                val intent = Intent(cont, CreateOrder::class.java)
                intent.putExtra("currentWorker", workers.get(position).wid)
                cont.startActivity(intent)
                println()
            }
        })
        holder.name.text = workers[position].name
        holder.salary.text = "" + workers[position].salary
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.worker_image_iv)
        val name: TextView = itemView.findViewById(R.id.worker_name)
        val salary: TextView = itemView.findViewById(R.id.worker_salary)
    }
}