package com.example.lab3eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_KEY = "MsgKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button);

        final EditText editText = findViewById(R.id.editText2);
        final Intent newActivityIntent = new Intent(this, TimerActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 newActivityIntent.putExtra(MESSAGE_KEY, editText.getText().toString());
                 startActivity(newActivityIntent);
            }
        });
    }
}
