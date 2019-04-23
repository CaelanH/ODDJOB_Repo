package com.example.oddjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class AddJobActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference jobRef = database.getReference().child("jobs");
    private DatabaseReference userRef = database.getReference().child("users");
    private String TAG = "AddJobActivity";
    public String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);

        final EditText mTitle = findViewById(R.id.jobTitle);
        final EditText mDescription = findViewById(R.id.jobDescription);
        final Spinner mCategory = findViewById(R.id.spinner);
        final EditText mLocation = findViewById(R.id.jobLocation);
        final EditText mTime = findViewById(R.id.jobTime);
        final Spinner mAmPm = findViewById(R.id.timeSpinner);
        final EditText mPrice = findViewById(R.id.price);
        final EditText mRequirements = findViewById(R.id.requirements);
        final EditText mAdditionalInformation = findViewById(R.id.additionalInformation);

        final DatePicker mDate = (DatePicker) findViewById(R.id.datePicker);
        final int day = mDate.getDayOfMonth();
        final int month = mDate.getMonth();
        final int year = mDate.getYear();

        // Variables to add to each job node in the database, but not provided by the user

        // get user ID
        readUserIdFromDatabase(); // TODO : Get correct user ID from database **MAKE SURE THIS WORKS!!!

        // array of applicants started at all values of -1 to be modified when apply to jobs
        final int[] mApplicants = new int[20];
//        for(int x = 0; x < 20; x ++)
//        {
//            mApplicants[x] = -1;
//        }

//        final ULocale.Category mCategory = findViewById(R.id.category);

        Button mSubmit = findViewById(R.id.submitButton);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                writeToDatabase(mTitle, mDescription, mCategory, mLocation, mDate, mTime, mAmPm, mRequirements, mAdditionalInformation, mUserId, mApplicants, mPrice);

                // reset fields
                mTitle.setText("");
                mDescription.setText("");
                mLocation.setText("");
                mTime.setText("");
                mRequirements.setText("");
                mAdditionalInformation.setText("");
                mPrice.setText("");
                // mUserId.setText("");
            }
        });
    }

    private void readUserIdFromDatabase() { // does this work ??? because i am confused by this for loop ...
        // Read from the database
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String userId = ds.child("User ID").getValue(String.class);
                    /// Log.d(TAG, "Value is: " + userId);
                    mUserId = userId;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    private void writeToDatabase(EditText mTitle, EditText mDescription, Spinner mCategory, EditText mLocation, DatePicker mDate, EditText mTime, Spinner mAmPm, EditText mRequirements, EditText mAdditionalInformation, String mUserId, int[] mApplicants, EditText mPrice) {
        // Write a message to database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // DatabaseReference myRef = database.getReference().child("jobs");
        Map<String, String> map = new HashMap<String, String>();
        map.put("Title", mTitle.getText().toString());
        map.put("Description", mDescription.getText().toString());
        map.put("Category", mCategory.getSelectedItem().toString());
        map.put("Location", mLocation.getText().toString());
        map.put("AMPM", mAmPm.getSelectedItem().toString());
        map.put("Requirements", mRequirements.getText().toString());
        map.put("Additional Information", mAdditionalInformation.getText().toString());
        map.put("Day", String.valueOf(mDate.getDayOfMonth()));
        map.put("Month", String.valueOf(mDate.getMonth()));
        map.put("Year", String.valueOf(mDate.getYear()));
        map.put("User ID", mUserId);
        map.put("Time", mTime.getText().toString());
        map.put("Pay", mPrice.getText().toString()); // need to make into integer ???
        // map.put("Applicants", )

//        Map<String, Integer> map1 = new HashMap<String, Integer>(); // TODO figure out how to do this with integers ...
//        map1.put("Day", mDate.getDayOfMonth());
//        map1.put("Month", mDate.getMonth());
//        map1.put("Year", mDate.getYear());
//        map1.put("User ID", mUserId);
//        map1.put("Time", Integer.parseInt(mTime.getText().toString()));
//        map1.put("Pay", Integer.parseInt(mPrice.getText().toString())); // need to make into integer ???

        Map<String, int[]> map2 = new HashMap<String, int[]>();
        map2.put("applicants", mApplicants);

        // TODO does this work?? or replace value??
        jobRef.push().setValue(map);
        // jobRef.push().setValue(map1);
        // jobRef.push().setValue(map2);

        Toast.makeText(AddJobActivity.this, "Push Successful", Toast.LENGTH_SHORT).show();

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
