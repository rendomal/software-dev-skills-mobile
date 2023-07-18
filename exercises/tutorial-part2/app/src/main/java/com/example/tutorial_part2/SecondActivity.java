package com.example.tutorial_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("com.mysite.MESSAGE")) {
            TextView textView = (TextView) findViewById(R.id.textView);

            String text = getIntent().getExtras().getString("com.mysite.MESSAGE");
            textView.setText(text);
        }
    }
}