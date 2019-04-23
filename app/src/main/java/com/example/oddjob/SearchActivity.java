package com.example.oddjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchActivity extends AppCompatActivity {

    private Button mLocation;
    private Button mDate;
    private Button mJob;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference jobRef = database.getReference().child("jobs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mLocation = findViewById(R.id.location_button);
        mDate = findViewById(R.id.date_button);
        mJob = findViewById(R.id.job_button);

        mLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });

//        mDate.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), SearchJobsDate.class);
//                startActivity(i);
//            }
//        });

//        mJob.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), SearchJobsActivity.class);
//                startActivity(i);
//            }
//        });
    }
}
