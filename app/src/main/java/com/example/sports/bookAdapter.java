package com.example.sports;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.ViewHolder>{


    Context context;
    ArrayList<booking> bookingArrayList;
    ArrayList<booking> bookingArrayListFull;

    public bookAdapter(Context context, ArrayList<booking> bookingArrayList) {
        this.context = context;
        this.bookingArrayList= bookingArrayList;
    }



    @NonNull
    @Override
    public bookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row2,parent,false);
        return new bookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookAdapter.ViewHolder holder, int position) {
        booking b = bookingArrayList.get(position);
        holder.clubname.setText(b.getClubname());
        holder.clubaddress.setText(b.getClubaddress());
        holder.clubsport.setText(b.getClubsport());
        holder.clubprice.setText(b.getClubprice());
        holder.date.setText(b.getDate());
        holder.time.setText(b.getTime());
        String c = String.valueOf(b.getCount());
        holder.count.setText(c);
        String t = String.valueOf(b.getCost());
        holder.cost.setText(t);
    }

    @Override
    public int getItemCount() {
        return bookingArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView clubname,clubaddress,clubsport,clubprice;
        TextView date,time,count,cost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clubname = itemView.findViewById(R.id.clubName);
            clubaddress = itemView.findViewById(R.id.clubAddress);
            clubsport = itemView.findViewById(R.id.clubsport);
            clubprice = itemView.findViewById(R.id.clubprice);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            count = itemView.findViewById(R.id.count);
            cost = itemView.findViewById(R.id.cost);
        }
    }
}
