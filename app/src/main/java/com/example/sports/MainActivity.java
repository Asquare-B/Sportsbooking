package com.example.sports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.sports.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ClubAdapter clubAdapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Clubs> arrayList = new ArrayList<Clubs>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clubAdapter = new ClubAdapter(this, arrayList);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Item List");

        title = new String[]{"AALAP CLUB","BHARGAV CLUB"};
        description = new String[]{"CHALA MA CHE","ME TANE AADI?"};
        icon = new int[]{R.drawable.images,R.drawable.club2};
        for(int i=0;i<title.length;i++){
            Clubs c = new Clubs(title[i],description[i],icon[i]);
            arrayList.add(c);
        }
        recyclerView.setAdapter(clubAdapter);
    }

    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                }
                else{
                    //clubAdapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.settings){
            //do your functionality of of bookings;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}