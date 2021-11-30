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
import java.util.Locale;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> implements Filterable {

    Context context;
    ArrayList<Clubs> clubsArrayList;
    ArrayList<Clubs> clubsArrayListFull;

    public ClubAdapter(Context context, ArrayList<Clubs> clubsArrayList) {
        this.context = context;
        this.clubsArrayListFull = clubsArrayList;
        this.clubsArrayList = new ArrayList<Clubs>(clubsArrayListFull);

    }

    @NonNull
    @Override
    public ClubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubAdapter.ViewHolder holder, int position) {
        Clubs c = clubsArrayList.get(position);
        holder.name.setText(c.name);
        holder.address.setText(c.address);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.name.getContext(),ClubDetails.class);
                intent.putExtra("name",c.getName());
                intent.putExtra("address",c.getAddress());
                intent.putExtra("price",c.getPrice());
                intent.putExtra("sport",c.getSport());
                intent.putExtra("id",c.getId());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.name.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return clubsArrayList.size();
    }

    private final Filter clubFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Clubs> filterClubArray = new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0){
                filterClubArray.addAll(clubsArrayListFull);
            }else{
                String filterPatter = charSequence.toString().toLowerCase(Locale.ROOT).trim();
                for(Clubs clubs : clubsArrayListFull){
                    if(clubs.name.toLowerCase().contains(filterPatter)){
                        filterClubArray.add(clubs);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterClubArray;
            results.count = filterClubArray.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            clubsArrayList.clear();
            clubsArrayList.addAll((ArrayList) filterResults.values);
            notifyDataSetChanged();

        }
    };

    @Override
    public Filter getFilter() {
        return clubFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.clubName);
            address = itemView.findViewById(R.id.clubAddress);
        }
    }
}