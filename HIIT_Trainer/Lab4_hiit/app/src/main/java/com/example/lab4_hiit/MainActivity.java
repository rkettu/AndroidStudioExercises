package com.example.lab4_hiit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //final String ADD_NEW_PART_KEY = "NewPart";
    static final String MESSAGE_KEY = "MsgKey";

    private int workoutLengthMinutes = 0;
    private int workoutLengthSeconds = 0;

    ArrayList<WorkoutPart> fullWorkout = new ArrayList<>();

    private MyAdapter myAdapter;
    private ListView listView;

    private TextView emptyText;
    private TextView lengthText;



    private void startWorkout()
    {
        if(fullWorkout.size() > 0) {
            final Intent newActivityIntent = new Intent(this, TimerActivity.class);
            newActivityIntent.putExtra(MESSAGE_KEY, fullWorkout);
            startActivity(newActivityIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyText = (TextView) findViewById(R.id.emptyText);
        lengthText = (TextView) findViewById(R.id.workoutLengthText);

        listView = (ListView) findViewById(R.id.workoutListView);

        myAdapter = new MyAdapter(this, fullWorkout);
        listView.setAdapter(myAdapter);

        findViewById(R.id.startWorkoutBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startWorkout();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menustuff, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final Intent intent = new Intent(this, AddWorkoutPartActivity.class);

        if (item.getItemId() == R.id.moiMenu)
        {
            startActivityForResult(intent, 9121);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        WorkoutPart returnWP = (WorkoutPart) data.getSerializableExtra("ResKey");
        if(returnWP.getSeconds() <= 0)
            return;
        fullWorkout.add(returnWP);
        emptyText.setVisibility(View.GONE);
        myAdapter.notifyDataSetChanged();
        updateLength(returnWP.getSeconds());
    }

    private void updateLength(int seconds)
    {
        workoutLengthSeconds += seconds;
        workoutLengthMinutes += workoutLengthSeconds / 60;
        workoutLengthSeconds %= 60;
        lengthText.setText("Total length " + workoutLengthMinutes + " minutes " + workoutLengthSeconds + " seconds");
    }
}
