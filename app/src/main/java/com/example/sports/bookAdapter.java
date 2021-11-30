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
        this.bookingArrayListFull= bookingArrayList;
        this.bookingArrayList = new ArrayList<booking>(bookingArrayListFull);
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
        holder.clubname.setText(b.clubname);
        holder.clubaddress.setText(b.clubaddress);

        holder.clubsport.setText(b.clubsport);
        holder.clubprice.setText(b.clubprice);
        holder.datetime.setText(b.date+"time"+b.time);

        holder.count.setText(b.count);
        holder.cost.setText(b.cost);
    }

    @Override
    public int getItemCount() {
        return bookingArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView clubname,clubaddress,clubsport,clubprice;
        TextView datetime,count,cost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clubname = itemView.findViewById(R.id.clubName);
            clubaddress = itemView.findViewById(R.id.clubAddress);
            clubsport = itemView.findViewById(R.id.clubsport);
            clubprice = itemView.findViewById(R.id.clubprice);
            datetime = itemView.findViewById(R.id.datetime);
            count = itemView.findViewById(R.id.count);
            cost = itemView.findViewById(R.id.cost);
        }
    }
}
