package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TypeActivity extends AppCompatActivity {
    private Button mStudentButton;
    private Button mNeighbourButton;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = mDatabase.getReference("users");
    HashMap<String,String> user2 = new HashMap<>();
    public void setHash(HashMap<String,String> user){
        user2 = user;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        mStudentButton = findViewById(R.id.student_button);
        mStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user2.put("Type", "Student");
                myRef.push().setValue(user2);
                sEditProfileActivity editprofileactivity = new sEditProfileActivity();
                editprofileactivity.setHash(user2);
                Intent i = new Intent(TypeActivity.this, sEditProfileActivity.class);
                startActivity(i);
            }
        });
        mNeighbourButton = findViewById(R.id.neighbour_button);
        mNeighbourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user2.put("Type", "Neighbour");
                myRef.push().setValue(user2);
                Intent i = new Intent(TypeActivity.this, nEditProfileActivity.class);
                startActivity(i);
            }
        });

    }
}
