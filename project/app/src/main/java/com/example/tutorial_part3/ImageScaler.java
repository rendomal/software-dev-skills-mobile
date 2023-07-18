package com.example.tutorial_part3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.lang.reflect.Field;

public class ImageScaler {

    public static int getImage(int index) {

        return getResId("cat_pic_0" + (index+1) + "_preview", R.drawable.class);

//        if (index == 0) {
//            return R.drawable.cat_pic_01_preview;
//        } else if (index == 1) {
//            return R.drawable.cat_pic_02_preview;
//        } else if (index == 2) {
//            return R.drawable.cat_pic_03_preview;
//        } else if (index == 3) {
//            return R.drawable.cat_pic_04_preview;
//        } else if (index == 4) {
//            return R.drawable.cat_pic_05_preview;
//        } else if (index == 5) {
//            return R.drawable.cat_pic_06_preview;
//        } else if (index == 6) {
//            return R.drawable.cat_pic_07_preview;
//        } else if (index == 7) {
//            return R.drawable.cat_pic_08_preview;
//        } else if (index == 8) {
//            return R.drawable.cat_pic_09_preview;
//        }
//        return 0;
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Bitmap scaleImage(WindowManager wm, Resources resources, int picture) {
        Display screen = wm.getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, picture, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, picture, options);
    }

}
