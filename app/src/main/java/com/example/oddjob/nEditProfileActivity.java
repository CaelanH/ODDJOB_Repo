package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oddjob.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class nEditProfileActivity extends AppCompatActivity {
    private EditText mName, mNeighbourhood, mJob, mAge,mBio;
    private Button mEditProfileButton;
    private Button mSubmit;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = mDatabase.getReference("users");
    private Bundle extras;
    private String userID;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_edit_profile);

        mEditProfileButton = findViewById(R.id.edit_button);
        mNeighbourhood = findViewById(R.id.Neighbourhood_Profile);
        mJob = findViewById(R.id.Job_Profile);
        mAge = findViewById(R.id.Age_Profile);
        mBio = findViewById(R.id.Bio_Profile);

        extras = getIntent().getExtras();

        userID = extras.getString("userID");
        user = (User) extras.getSerializable("user");

        mEditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change the picture somehow!!!!!!!!!!!!!!!!
            }
        });
        mSubmit = findViewById(R.id.submit_button);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setNeighbourhood(mNeighbourhood.getText().toString());
                user.setJob(mJob.getText().toString());
                user.setAge(mAge.getText().toString());
                user.setBio(mBio.getText().toString());
                // WRITE TO DATABASE
                myRef.child(userID).setValue(user);

                Intent i = new Intent(nEditProfileActivity.this, AddJobActivity.class);
                startActivity(i);
            }
        });
    }
}
