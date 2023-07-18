package com.example.tutorial_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);

                startIntent.putExtra("com.mysite.MESSAGE", "Hello World!");
                startActivity(startIntent);
            }
        });

        Button archLinuxButton = (Button) findViewById(R.id.archLinuxButton);
        archLinuxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String site = "https://archlinux.org/";
                Uri webAddress = Uri.parse(site);

                Intent goToArchLinux = new Intent(Intent.ACTION_VIEW, webAddress);
                if (goToArchLinux.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToArchLinux);
                }
            }
        });
    }
}