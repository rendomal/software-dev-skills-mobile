package com.example.tutorial_part3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rView;
    ListRowData listRowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();
        double minPrice = in.getIntExtra("com.mySite.MIN_PRICE", 0);
        double maxPrice = in.getIntExtra("com.mySite.MAX_PRICE", 100000);
        boolean allowWhiteBellies = in.getBooleanExtra("com.mySite.ALLOW_WHITE_BELLIES", true);

        TextView priceRangeEditText = (TextView) findViewById(R.id.priceRangeTextView);
        priceRangeEditText.setText("Showing price between " + minPrice + " - " + maxPrice);

        Resources res = getResources();
        String[] items = res.getStringArray(R.array.items);
        String[] prices = res.getStringArray(R.array.prices);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        String[] whiteBelly = res.getStringArray(R.array.whitebelly);

        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(items));
        ArrayList<String> priceList = new ArrayList<>(Arrays.asList(prices));
        ArrayList<String> descriptionList = new ArrayList<>(Arrays.asList(descriptions));
        ArrayList<String> whiteBellyList = new ArrayList<>(Arrays.asList(whiteBelly));
        ArrayList<Integer> imageIdList = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            imageIdList.add(i);
        }

        for (int i = items.length - 1; i >= 0; i--) {

            // Check if out of price range
            if (Double.parseDouble(priceList.get(i).substring(0, priceList.get(i).length() - 2)) < minPrice || // Substring to remove space and euro sign
                    Double.parseDouble(priceList.get(i).substring(0, priceList.get(i).length() - 2)) > maxPrice ||
                    (!allowWhiteBellies && Boolean.parseBoolean(whiteBellyList.get(i))) ) {
                itemList.remove(i);
                priceList.remove(i);
                descriptionList.remove(i);
                whiteBellyList.remove(i);
                imageIdList.remove(i);
            }
        }

        items = itemList.toArray(new String[0]);
        prices = priceList.toArray(new String[0]);
        descriptions = descriptionList.toArray(new String[0]);
        whiteBelly = whiteBellyList.toArray(new String[0]);
        int[] imageIds = new int[imageIdList.size()];
        for (int i = 0; i < imageIdList.size(); i++)
        {
            imageIds[i] = imageIdList.get(i);
        }

        listRowData = new ListRowData(items, prices, descriptions, whiteBelly, imageIds);

        rView = (RecyclerView) findViewById(R.id.recyclerView);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, getWindowManager(), listRowData, allowWhiteBellies);

        rView.setAdapter(myRecyclerViewAdapter);
        rView.setLayoutManager(new LinearLayoutManager(this));
    }
}