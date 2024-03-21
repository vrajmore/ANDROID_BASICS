package com.example.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Vpadapter extends RecyclerView.Adapter<Vpadapter.Viewholder> {

    ArrayList<Viewpageritems> viewpageritemsArrayList;

    public Vpadapter(ArrayList<Viewpageritems> viewpageritemsArrayList) {
        this.viewpageritemsArrayList = viewpageritemsArrayList;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpageritems, parent, false);
        return new Viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Viewpageritems viewpageritems = viewpageritemsArrayList.get(position);
        holder.pic.setImageResource(viewpageritems.imageid);
        holder.head.setText(viewpageritems.heading);
        holder.description.setText(viewpageritems.imagedescription);

    }
    @Override
    public int getItemCount() {
        return viewpageritemsArrayList.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder{

        ImageView pic;
        TextView head, description;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.imageView);
            head = itemView.findViewById(R.id.textView2);
            description = itemView.findViewById(R.id.textView3);
        }
    }
}
