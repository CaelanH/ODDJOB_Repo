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
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        mStudentButton = findViewById(R.id.student_button);
        mStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth  mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                DatabaseReference myUser = myRef.child(currentUser.getUid());

                user = new User(myUser);
                user.setType("Student");
                myUser.setValue(user);

                myUser.setValue(user);

                Intent i = new Intent(TypeActivity.this, sEditProfileActivity.class);
                startActivity(i);
            }
        });
        mNeighbourButton = findViewById(R.id.neighbour_button);
        mNeighbourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setType("Neighbour");
//                myRef.child(userID).setValue(user);
                Intent i = new Intent(TypeActivity.this, nEditProfileActivity.class);
                startActivity(i);
            }
        });

    }
}
