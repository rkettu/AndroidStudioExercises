package com.example.greetingssit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {
    private EditText greetingText;
    private EditText inputText;
    private String name;
    private int index;

    private void UpdateGreeting()
    {
        switch(index)
        {
            case 1:
                greetingText.setText("Hi " + name);
                break;
            case 2:
                greetingText.setText("Hejssan " + name);
                break;
            case 3:
                greetingText.setText("Terve " + name);
                break;
            case 4:
                greetingText.setText("Hola " + name);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = 0;
        name = "";

        final Button engButton = findViewById(R.id.engBtn);
        final Button sweButton = findViewById(R.id.sweBtn);
        final Button finButton = findViewById(R.id.finBtn);
        final Button surButton = findViewById(R.id.surBtn);
        greetingText = (EditText) findViewById(R.id.editText2);
        inputText = (EditText) findViewById(R.id.inputText);

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = inputText.getText().toString();
                UpdateGreeting();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        engButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index  = 1;
                UpdateGreeting();
            }
        });

        sweButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 2;
                UpdateGreeting();
            }
        });

        finButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 3;
                UpdateGreeting();
            }
        });

        surButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 4;
                UpdateGreeting();
            }
        });
    }
}
