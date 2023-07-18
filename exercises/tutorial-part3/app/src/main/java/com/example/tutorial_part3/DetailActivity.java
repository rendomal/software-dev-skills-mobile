package com.example.tutorial_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.mySite.ITEM_INDEX", -1);

        if (index == -1) return;

        int picture = getImage(index);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        scaleImage(imageView, picture);
    }

    private int getImage(int index) {
        if (index == 0) {
            return R.drawable.cat_00;
        } else if (index == 1) {
            return R.drawable.cat_01;
        } else if (index == 2) {
            return R.drawable.cat_02;
        }
        return -1;
    }

    private void scaleImage(ImageView imageView, int picture) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), picture, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), picture, options);
        imageView.setImageBitmap(scaledImg);
    }
}