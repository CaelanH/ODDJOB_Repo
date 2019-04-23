package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
    private DatabaseReference userRef = database.getReference().child("users");
    public User user;
    private Button mEditButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_messages:
                    // mTextMessage.setText(R.string.title_messages);

                    Intent h = new Intent(getApplicationContext(), MessageActivity.class);
                    startActivity(h);

                    return true;
                case R.id.navigation_search:
                    // mTextMessage.setText(R.string.title_search);

                    Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(i);

                    return true;
                case R.id.navigation_add:
                    // mTextMessage.setText(R.string.title_add);

                    Intent j = new Intent(getApplicationContext(), AddJobActivity.class);
                    startActivity(j);

                    return true;
                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);

                    Intent k = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(k);

                    return true;
                case R.id.navigation_profile:
                    // mTextMessage.setText(R.string.title_profile);

                    Intent l = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(l);

                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.Username);
        schoolNeighbourhood = findViewById(R.id.School);
        gradeJob = findViewById(R.id.Grade);
        age = findViewById(R.id.Age);
        bio = findViewById(R.id.Bio);
//        mEditButton = findViewById(R.id.editprofile_button);
        ReadFromDatabase();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_profile);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


//        mEditButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(user!=null)
//                {
//
//
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("user", user); // Put the user model object in the intent "extras"
//                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
//                    bundle.putString("userID", firebaseUser.getUid());
//
//                    if(user.getType().equals("Student")){
//                        Intent i = new Intent(ProfileActivity.this, sEditProfileActivity.class);
//                        i.putExtras(bundle);
//                        startActivity(i);
//                    }
//                    else
//                    {
//                        Intent i = new Intent(ProfileActivity.this, nEditProfileActivity.class);
//                        i.putExtras(bundle);
//                        startActivity(i);
//                    }
//                }
//            }
//        });
    }
    public void ReadFromDatabase(){
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                DataSnapshot ds = dataSnapshot.child(firebaseUser.getUid());
                user = ds.getValue(User.class);
                name.setText(user.getFirstName()+" "+user.getLastName());
                if(user.getType().equals("Student")){

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
