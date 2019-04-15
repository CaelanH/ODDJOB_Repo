package com.example.oddjob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.view.View.OnClickListener;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    Button mLocation;
    Button mTime;
    Button mJob;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        mLocation = findViewById(R.id.location_button);
        mTime = findViewById(R.id.time_button);
        mJob = findViewById(R.id.job_button);

        mLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                //startActivity(i);
            }
        });
    }

}
