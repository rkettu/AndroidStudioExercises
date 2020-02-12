package com.example.lab4_hiit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class AddWorkoutPartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout_part);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText secondsText = findViewById(R.id.editText2);
                int sekunnit = 0;
                try
                {
                    sekunnit = Integer.parseInt(secondsText.getText().toString());
                }
                catch(Exception e)
                {
                    sekunnit = 0;
                }
                String hommanNimi;
                RadioButton rad1 = findViewById(R.id.workoutRadio);

                if(rad1.isChecked())
                {
                    hommanNimi = "Workout";
                }
                else hommanNimi = "Pause";

                if(sekunnit > 300) sekunnit = 300;

                WorkoutPart palautettava = new WorkoutPart(sekunnit, hommanNimi);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("ResKey", palautettava);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
