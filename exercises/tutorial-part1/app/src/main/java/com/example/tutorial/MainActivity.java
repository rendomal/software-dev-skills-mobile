package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input1EditText = (EditText) findViewById(R.id.input1_editText);
                EditText input2EditText = (EditText) findViewById(R.id.input2_editText);
                TextView resultTextView = (TextView) findViewById(R.id.result_textView);

                int input1 = Integer.parseInt(input1EditText.getText().toString());
                int input2 = Integer.parseInt(input2EditText.getText().toString());
                int result = input1 + input2;
                resultTextView.setText(result + "");
            }
        });
    }
}