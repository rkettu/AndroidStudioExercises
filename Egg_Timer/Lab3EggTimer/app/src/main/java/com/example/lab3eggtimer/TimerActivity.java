package com.example.lab3eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import static java.lang.Math.round;


public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_KEY);

        final TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        new CountDownTimer(Integer.parseInt(message)*1000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                textView.setText("" + round((float)millisUntilFinished/1000));
            }
            public void onFinish()
            {
                finish();
            }
        }.start();
    }
}
