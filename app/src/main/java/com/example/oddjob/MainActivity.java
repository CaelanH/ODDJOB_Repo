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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference jobRef = database.getReference().child("jobs");
    private DatabaseReference userRef = database.getReference().child("users");
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private String string;

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
        setContentView(R.layout.activity_main);

        // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Button mHired = findViewById(R.id.hired_button);
        Button mCompleted = findViewById(R.id.completed_button);

        mHired.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have no jobs on the Hired list.", Toast.LENGTH_SHORT).show();
            }
        });

        mCompleted.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have no jobs on the Completed list.", Toast.LENGTH_SHORT).show();
            }
        });

//        mAuth = FirebaseAuth.getInstance();
//        user = mAuth.getCurrentUser();
//        DatabaseReference myUser = userRef.child(user.getUid());
//        boolean x = true;
//        String mType = user.getType();

//        userRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String type = dataSnapshot.child("Type").getValue(String.class);
//
//                if( type == "Neighbour" ) {
//
//                }
//                else {
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//            }
//        });



//        ViewPager viewPager = findViewById(R.id.viewPager);
//        ViewPagerAdapter viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
    }

    private void getUserType() {
        // Read from the database
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String userId = ds.child("User ID").getValue(String.class);
                    /// Log.d(TAG, "Value is: " + userId);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

//    class ViewPagerAdapter extends FragmentPagerAdapter {
//
//        private ArrayList<Fragment> fragments;
//        private ArrayList<String> titles;
//
//        ViewPagerAdapter(FragmentManager fm) {
//            super(fm);
//            this.fragments = new ArrayList<>();
//            this.titles = new ArrayList<>();
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            return fragments.get(i);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        public void addFragment (Fragment fragment, String title) {
//            fragments.add(fragment);
//            titles.add(title);
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return titles.get(position);
//        }
//    }

    /*
    private void writeToDatabase() {
        // Write a message to database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("messages");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef.push().setValue("Hello, this is a test");
        boolean x =true;
    }
    */
}
