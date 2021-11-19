package com.example.sports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ClubAdapter extends ArrayAdapter<Clubs>{

    public ClubAdapter(Context context, ArrayList<Clubs> clubArrayList){

        super(context, R.layout.listview_item, (List<Clubs>) clubArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Clubs user = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item,parent,false);

        }


        TextView userName = convertView.findViewById(R.id.clubName);
        TextView lastMsg = convertView.findViewById(R.id.address);


        userName.setText(user.name);
        lastMsg.setText(user.add);


        return convertView;
    }
}
