package com.example.sports;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClubHolder extends RecyclerView.ViewHolder {

    ImageView clubLogo;
    TextView name,add;

    public ClubHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.clubName);
        this.add = itemView.findViewById(R.id.clubaddress);
    }
}
