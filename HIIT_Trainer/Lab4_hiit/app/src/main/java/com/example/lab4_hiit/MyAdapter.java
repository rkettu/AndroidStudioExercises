package com.example.lab4_hiit;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<WorkoutPart> {

    public MyAdapter(Context context, ArrayList<WorkoutPart> lista)
    {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        WorkoutPart currentWorkoutPart = getItem(position);
        View listItem = convertView;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView workoutPartName = (TextView) convertView.findViewById(R.id.listItemName);
        String saatu_nimi = currentWorkoutPart.getName();
        workoutPartName.setText(saatu_nimi);

        if(saatu_nimi.toUpperCase().equals("PAUSE"))
        {
            LinearLayout bgElement = (LinearLayout) convertView.findViewById(R.id.container);
            bgElement.setBackgroundColor(Color.LTGRAY);
        }

        TextView workoutPartDuration = (TextView) convertView.findViewById(R.id.listItemDuration);
        workoutPartDuration.setText(String.valueOf(currentWorkoutPart.getSeconds()));

        return convertView;
    }
}
