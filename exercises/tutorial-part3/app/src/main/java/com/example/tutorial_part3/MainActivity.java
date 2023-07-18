package com.example.tutorial_part3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rView;
    ListRowData listRowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] items = res.getStringArray(R.array.items);
        String[] prices = res.getStringArray(R.array.prices);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        listRowData = new ListRowData(items, prices, descriptions);

        rView = (RecyclerView) findViewById(R.id.recyclerView);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, listRowData);

        rView.setAdapter(myRecyclerViewAdapter);
        rView.setLayoutManager(new LinearLayoutManager(this));
    }
}