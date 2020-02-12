package com.example.a21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ArrayList<String> COUNTRIES;
    private ArrayAdapter<String> aa;

    private void functionAddCountry()
    {
        String myText = editText.getText().toString();
        COUNTRIES.add(myText);
        aa.notifyDataSetChanged();
    }

    private void functionRemoveCountry()
    {
        String myText = editText.getText().toString();
        COUNTRIES.remove(myText);
        aa.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] placeholderArray = {"Afghanistan", "MMMMMMM", "EEEEEEEEE",
                "IIIIIIIII", "PPPPPPPPPPPPPP", "JAAAAAAAAAA",
                "MOI", "KKKKKKKKK", "D", "L"};


        COUNTRIES = new ArrayList<String>();
        COUNTRIES.addAll(Arrays.asList(placeholderArray));

        editText = (EditText) findViewById(R.id.editti1);

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                COUNTRIES);

        final Button buttonAdd = (Button) findViewById(R.id.nappi1);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionAddCountry();
            }
        });

        final Button buttonRemove = (Button) findViewById(R.id.nappi3);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionRemoveCountry();
            }
        });

        ListView myListView = findViewById(R.id.lista1);


        myListView.setAdapter(aa);


    }
}

