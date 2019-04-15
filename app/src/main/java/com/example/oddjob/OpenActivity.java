package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class OpenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(OpenActivity.this, WelcomeActivity.class));
            }
        }, 2000);
    }
}
