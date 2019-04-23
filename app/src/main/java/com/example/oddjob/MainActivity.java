package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // private TextView mTextMessage;
    // BlankFragment mFragment;
    // FrameworksFragment frameworksFragment;
    // FrameLayout content;
    // android.support.v4.app.FragmentManager fragmentManager;
//
//    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
//    static final LatLng KIEL = new LatLng(53.551, 9.993);
//    private GoogleMap map;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//        //map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//
//        Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
//        Marker kiel = map.addMarker(new MarkerOptions()
//                .position(KIEL)
//                .title("LAWNMOWING")
//                .snippet("$PRICE")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_foreground)));
//
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));
//        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
//    }
//}

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_messages:
                    // mTextMessage.setText(R.string.title_messages);
                    return true;
                case R.id.navigation_search:
                    // mTextMessage.setText(R.string.title_search);

                    Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(i);

                    return true;
                case R.id.navigation_add:
                    // mTextMessage.setText(R.string.title_add);

                    Intent j = new Intent(getApplicationContext(), AddJobActivity.class);
                    startActivity(j);

                    return true;
                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_profile:
                    // writeToDatabase();
                    // mTextMessage.setText(R.string.title_profile);

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

//        ViewPager viewPager = findViewById(R.id.viewPager);
//        ViewPagerAdapter viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());


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
