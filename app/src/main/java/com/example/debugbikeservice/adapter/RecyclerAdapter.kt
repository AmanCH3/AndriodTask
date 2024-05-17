package com.example.debugbikeservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.debugbikeservice.R

class RecyclerAdapter (var list : List<String> , var imgs : List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(var view : View) : RecyclerView.ViewHolder(view){

        var title : TextView = view.findViewById(R.id.textName)
        var imageView : ImageView = view.findViewById(R.id.imageView3)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var  view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent ,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text  = list[position]
        holder.imageView.setImageResource(imgs[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }



}