package com.example.sports;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sports.Clubs;
import com.example.sports.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClubAdapter extends RecyclerView.Adapter<ClubHolder> {

    Context context;
    ArrayList<Clubs> club;

    public ClubAdapter(Context context, ArrayList<Clubs> club) {
        this.context = context;
        this.club = club;
    }

    @NonNull
    @Override
    public ClubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row,null);
        return new ClubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubHolder holder, int position) {
        holder.name.setText(club.get(position).getName());
        holder.add.setText(club.get(position).getAdd());
        holder.clubLogo.setImageResource(club.get(position).getLogo());

    }

    @Override
    public int getItemCount() {
        return club.size();
    }
}