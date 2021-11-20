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

import com.example.sports.Clubs;
import com.example.sports.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClubAdapter extends BaseAdapter{

    Context mContext;
    LayoutInflater inflater;
    List<Clubs> clubList;
    ArrayList<Clubs> arrayList;

    public ClubAdapter (Context mContext, List<Clubs> clubList){
        this.mContext = mContext;
        this.clubList = clubList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Clubs>();
        this.arrayList.addAll(clubList);

    }

    @Override
    public int getCount() {
        return clubList.size();
    }

    @Override
    public Object getItem(int i) {
        return clubList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public  class ViewHolder{
        TextView mTitleTv,mDescTv;
        ImageView mIconTv;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconTv = view.findViewById(R.id.mainIcon);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mTitleTv.setText(clubList.get(position).getTitle());
        holder.mDescTv.setText(clubList.get(position).getDesc());
        holder.mIconTv.setImageResource(clubList.get(position).getIcon());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if(clubList.get(position).getTitle().equals("AALAP CLUB")){
                    Intent intent = new Intent(mContext,Details.class);
                    intent.putExtra("actionBarTitle","AALAP CLUB");
                    intent.putExtra("contentTV","Provides Bastketball facilty");
                    mContext.startActivity(intent);
                }
                if(clubList.get(position).getTitle().equals("BHARGAV CLUB")){
                    Intent intent = new Intent(mContext,Details.class);
                    intent.putExtra("actionBarTitle","BHARGAV CLUB");
                    intent.putExtra("contentTV","Provides Football facilty");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        clubList.clear();
        if (charText.length()==0){
            clubList.addAll(arrayList);
        }
        else{
            for (Clubs club : arrayList){
                if(club.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                    clubList.add(club);
                }
            }
        }
        notifyDataSetChanged();
    }
}