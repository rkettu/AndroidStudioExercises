package com.example.lab4_hiit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Math.round;

public class TimerActivity extends AppCompatActivity {

    private TextToSpeech tts = null;
    private TextView workoutText;
    private ArrayList<WorkoutPart> myWorkout;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        workoutText = (TextView) findViewById(R.id.workoutInfoText);

        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });

        Intent intent = getIntent();
        myWorkout = (ArrayList<WorkoutPart>) intent.getSerializableExtra(MainActivity.MESSAGE_KEY);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TimerActivities();
            }
        }, 1000);
    }

    private void TimerActivities()
    {
        final String workoutName = myWorkout.get(index).getName().toUpperCase();

        tts.speak(workoutName, TextToSpeech.QUEUE_FLUSH, null);

        new CountDownTimer(myWorkout.get(index).getSeconds()*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                workoutText.setText(workoutName +"\n" + round((float)millisUntilFinished / 1000));
            }
            public void onFinish() {
                if(++index < myWorkout.size()) {
                    TimerActivities();
                }
                else finish();
            }
        }.start();
    }
}
