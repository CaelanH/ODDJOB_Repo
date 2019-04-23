package com.example.oddjob;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_messages:
                    // mTextMessage.setText(R.string.title_messages);

                    Intent h = new Intent(getApplicationContext(), MessageActivity.class);
                    startActivity(h);

                    return true;
                case R.id.navigation_search:
                    // mTextMessage.setText(R.string.title_search);

                    Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(i);

                    return true;
                case R.id.navigation_add:
                    // mTextMessage.setText(R.string.title_add);

                    Intent j = new Intent(getApplicationContext(), AddJobActivity.class);
                    startActivity(j);

                    return true;
                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);

                    Intent k = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(k);

                    return true;
                case R.id.navigation_profile:
                    // mTextMessage.setText(R.string.title_profile);

                    Intent l = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(l);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
