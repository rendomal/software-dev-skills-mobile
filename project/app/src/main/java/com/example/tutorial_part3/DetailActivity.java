package com.example.tutorial_part3;

import static com.example.tutorial_part3.ImageScaler.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.mySite.ITEM_INDEX", -1);

        String name = in.getStringExtra("com.mySite.ITEM_NAME");
        ((TextView)findViewById(R.id.detailNameTextView)).setText(name);

        String desc = in.getStringExtra("com.mySite.ITEM_DESCRIPTION");
        ((TextView)findViewById(R.id.detailInfoTextView)).setText(desc);

        String price = in.getStringExtra("com.mySite.ITEM_PRICE");
        ((TextView)findViewById(R.id.detailPriceTextView)).setText(price);

        if (index == -1) return;

        int picture = getImage(index);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(scaleImage(getWindowManager(), getResources(), picture));
    }


}