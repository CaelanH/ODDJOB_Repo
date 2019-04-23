package com.example.oddjob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.oddjob.Model.User;

public class ProfileActivity extends AppCompatActivity {
    public TextView name;
    public TextView schoolNeighbourhood;
    public TextView gradeJob;
    public TextView age;
    public TextView bio;
    public User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.Username);
        schoolNeighbourhood = findViewById(R.id.School);
        gradeJob = findViewById(R.id.Grade);
        age = findViewById(R.id.Age);
        bio = findViewById(R.id.Bio);
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
}
