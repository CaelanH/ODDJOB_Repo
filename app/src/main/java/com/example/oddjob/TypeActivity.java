package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.example.oddjob.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TypeActivity extends AppCompatActivity {
    private Button mStudentButton;
    private Button mNeighbourButton;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = mDatabase.getReference("users");
    private Bundle extras;
    private User user;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        mStudentButton = findViewById(R.id.student_button);

        extras = getIntent().getExtras();

        userID = extras.getString("userID");
        user = (User) extras.getSerializable("user"); // Retrieve the user model object we set in RegisterActivity.java

        mStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setType("Student");

                myRef.child(userID).setValue(user);

                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user); // Put the user model object in the intent "extras"
                bundle.putString("userID", userID);

                Intent i = new Intent(TypeActivity.this, sEditProfileActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        mNeighbourButton = findViewById(R.id.neighbour_button);
        mNeighbourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                user.setType("NeighbFour");
//                myRef.child(userID).setValue(user);
                Intent i = new Intent(TypeActivity.this, nEditProfileActivity.class);
                startActivity(i);
            }
        });

    }
}
