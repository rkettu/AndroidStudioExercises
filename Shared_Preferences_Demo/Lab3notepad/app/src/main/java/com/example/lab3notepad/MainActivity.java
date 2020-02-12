package com.example.lab3notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private final String MY_PREFS_NAME = "MyPrefs";
    private final String MY_PREFS_TEXT_KEY = "MyText";
    EditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        textEdit = (EditText) findViewById(R.id.textEdit);
        textEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString(MY_PREFS_TEXT_KEY, textEdit.getText().toString());
                editor.apply();
            }
        });
        textEdit.setText(sharedPreferences.getString(MY_PREFS_TEXT_KEY, ""));
    }
}
