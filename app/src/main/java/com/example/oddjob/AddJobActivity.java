package com.example.oddjob;

import android.icu.util.ULocale;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddJobActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference().child("jobs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        int SIZE = 20;

        final EditText mTitle = findViewById(R.id.jobTitle);
        final EditText mDescription = findViewById(R.id.jobDescription);
        final EditText mLocation = findViewById(R.id.jobLocation);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        int day = datePicker.getDayOfMonth();

        // final ULocale.Category mCategory = findViewById(R.id.category);
        final int[] applicants = new int[SIZE];

        for(int x = 0; x < SIZE; x++)
        {

        }

        Button mSubmit = findViewById(R.id.submitButton);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                writeToDatabase(mTitle, mDescription, mLocation);

                mTitle.setText("");
                mDescription.setText("");
                mLocation.setText("");
                // mCategory.setCategory ...


            }
        });
    }

    private void writeToDatabase(EditText mTitle, EditText mDescription, EditText mLocation) {
        // Write a message to database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // DatabaseReference myRef = database.getReference().child("jobs");
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", mTitle.getText().toString());
        map.put("description", mDescription.getText().toString());
        map.put("location", mLocation.getText().toString());
//        map.put("time", mTime.getText().toString());

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
