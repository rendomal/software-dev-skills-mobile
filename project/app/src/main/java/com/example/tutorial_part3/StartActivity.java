package com.example.tutorial_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button add = (Button) findViewById(R.id.searchButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText minPriceEditText = (EditText) findViewById(R.id.minPriceEditText);
                EditText maxPriceEditText = (EditText) findViewById(R.id.maxPriceEditText);

                String minPriceString = minPriceEditText.getText().toString();
                String maxPriceString = maxPriceEditText.getText().toString();

                int minPrice = minPriceString.equals("") ? 0 : (int)Double.parseDouble(minPriceString);
                if (minPrice < 0) minPrice = 0;
                int maxPrice = maxPriceString.equals("") ? 1000000 : (int)Double.parseDouble(maxPriceString);
                if (maxPrice < 0) maxPrice = 0;

                Switch whiteBellySwitch = (Switch) findViewById(R.id.whiteBellySwitch);

                Intent listActivity = new Intent(getApplicationContext(), MainActivity.class);
                listActivity.putExtra("com.mySite.MIN_PRICE", minPrice);
                listActivity.putExtra("com.mySite.MAX_PRICE", maxPrice);
                listActivity.putExtra("com.mySite.ALLOW_WHITE_BELLIES", whiteBellySwitch.isChecked());
                startActivity(listActivity);
            }
        });
    }
}