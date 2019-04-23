package com.example.oddjob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.oddjob.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    public TextView name;
    public TextView schoolNeighbourhood;
    public TextView gradeJob;
    public TextView age;
    public TextView bio;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference jobRef = database.getReference().child("jobs");
    public User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.Username);
        schoolNeighbourhood = findViewById(R.id.School);
        gradeJob = findViewById(R.id.Grade);
        age = findViewById(R.id.Age);
        bio = findViewById(R.id.Bio);
        ReadFromDatabase();

    }
    public void ReadFromDatabase(){
        jobRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                DataSnapshot ds = dataSnapshot.child(firebaseUser.getUid());
                User user = ds.getValue(User.class);
                name.setText(user.getFirstName()+" "+user.getLastName());
                if (user.getType() == "Student"){
                    schoolNeighbourhood.setText(user.getSchool());
                    gradeJob.setText(user.getGrade());}
                else{
                    schoolNeighbourhood.setText(user.getNeighbourhood());
                    gradeJob.setText(user.getJob());}
                age.setText(user.getAge());
                bio.setText(user.getBio());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ProfileActivity", "Failed to read value.", error.toException());
            }
        });

    }
}
