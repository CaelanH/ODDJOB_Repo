package com.example.oddjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class AddJobActivity extends AppCompatActivity {

    /*
    private EditText mTitle = findViewById(R.id.jobTitle);
    private EditText mDescription = findViewById(R.id.jobDescription);
    private EditText mLocation = findViewById(R.id.jobLocation);
    private EditText mTime = findViewById(R.id.jobTime);
    private Button mSubmit = findViewById(R.id.submitButton);
    */
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference().child("jobs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);

        final EditText mTitle = findViewById(R.id.jobTitle);
        final EditText mDescription = findViewById(R.id.jobDescription);
        final EditText mLocation = findViewById(R.id.jobLocation);
        final EditText mTime = findViewById(R.id.jobTime);
        Button mSubmit = findViewById(R.id.submitButton);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                writeToDatabase(mTitle, mDescription, mLocation, mTime);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        Intent i = new Intent(getApplicationContext(), AddJobActivity.class);
        startActivity(i);
    }

    private void writeToDatabase(EditText mTitle, EditText mDescription, EditText mLocation, EditText mTime) {
        // Write a message to database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // DatabaseReference myRef = database.getReference().child("jobs");
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", mTitle.getText().toString());
        map.put("description", mDescription.getText().toString());

//        myRef.setValue(map);
         myRef.push().setValue(map);


    }

    /*
    private void readFromDatabase() {
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    */
}
