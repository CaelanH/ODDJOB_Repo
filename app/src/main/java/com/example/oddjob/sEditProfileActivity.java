package com.example.oddjob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sEditProfileActivity extends AppCompatActivity {
    private EditText mName, mSchool, mGrade, mAge,mBio;
    private Button mEditProfileButton;
    private Button mSubmit;
    HashMap<String,String> user2 = new HashMap<>();
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = mDatabase.getReference("users");
    public void setHash(HashMap<String,String> user){
        user2 = user;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEditProfileButton = findViewById(R.id.edit_button);
        mSchool = findViewById(R.id.School_Profile);
        mGrade = findViewById(R.id.Grade_Profile);
        mAge = findViewById(R.id.Age_Profile);
        mBio = findViewById(R.id.Bio_Profile);
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
                user2.put("School", mSchool.getText().toString());
                user2.put("Grade", mGrade.getText().toString());
                user2.put("Age", mAge.getText().toString());
                user2.put("Bio", mBio.getText().toString());
                sEditProfileActivity editprofileactivity = new sEditProfileActivity();
                editprofileactivity.setHash(user2);
                Intent i = new Intent(sEditProfileActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
    }
}
