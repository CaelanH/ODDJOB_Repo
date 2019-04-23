package com.example.oddjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button mHired = findViewById(R.id.hired_button);
        Button mCompleted = findViewById(R.id.completed_button);

        mHired.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "You have no jobs on the Hired list.", Toast.LENGTH_SHORT).show();
            }
        });

        mCompleted.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "You have no jobs on the Completed list.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
