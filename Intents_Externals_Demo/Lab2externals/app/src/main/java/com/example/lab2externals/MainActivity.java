package com.example.lab2externals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent openMapIntent;
    Intent createCallIntent;
    Intent openWebIntent;
    EditText webEditText;

    private void openMap()
    {
        startActivity(openMapIntent);
    }

    private void createCall()
    {
        startActivity(createCallIntent);
    }

    private void makeSearch()
    {
        String webaddress = webEditText.getText().toString();
        Uri webpage = Uri.parse("https:/" + webaddress);
        openWebIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(openWebIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webEditText = (EditText) findViewById(R.id.webEditText);

        Uri phoneNumber = Uri.parse("tel:0206110200");
        createCallIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);

        Uri location = Uri.parse("geo:0,0?q=Kotkantie+1+Oulu");
        openMapIntent = new Intent(Intent.ACTION_VIEW, location);

        final Button mapBtn = findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMap();
            }
        });

        final Button callBtn = findViewById(R.id.callBtn);
        callBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createCall();
            }
        });

        final Button goBtn = findViewById(R.id.goBtn);
        goBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeSearch();
            }
        });
    }
}
