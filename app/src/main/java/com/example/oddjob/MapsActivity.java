package com.example.oddjob;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String TAG="MapsActivity";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference jobRef = database.getReference().child("jobs");
    private Geocoder geocoder;
    private LatLng Calgary = new LatLng(51, -114);
    private String jobTitle;
    private String pay;
    private int MY_LOCATION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this.getApplicationContext());


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            boolean x = false;
            // Show rationale and request permission.
        }

        // display code from firebase on jobs
        readLocationFromDatabase();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Calgary, 10));
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
    }

    public void getCoordinatesFromAddress(String location) {
        try {
            List<Address> addresses= geocoder.getFromLocationName(location, 1);
            Address jobAddress = addresses.get(0);
            jobAddress.getLatitude();

            LatLng jobLocation = new LatLng(jobAddress.getLatitude(), jobAddress.getLongitude());
//            mLocation = jobLocation;

            // markJobLocation(jobLocation);

            mMap.addMarker(new MarkerOptions().position(jobLocation).title(jobTitle).snippet(pay));

            // mMap.moveCamera(CameraUpdateFactory.newLatLng(jobLocation));

//            float zoomLevel = 16.0f; //This goes up to 21
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jobLocation, zoomLevel));

        } catch (IOException e) {

        }
    }

//    public void markJobLocation(final LatLng jobLocation) {
//        jobRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // this method is called once with the initial value and again
//                // whenever data at this location is updated
//                for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                    String jobTitle = ds.child("job title").getValue(String.class);
//                    Log.d(TAG, "Value is: " + jobTitle);
//
//                    // adds marker with title "lawnmowing" to location at which lawnmowing is at TODO I THINK!!!
//                    mMap.addMarker(new MarkerOptions().position(jobLocation).title(jobTitle));
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) { // inconsistency
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//        });
//    }

    private void readLocationFromDatabase() {
        // Read from the database
        jobRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String location = ds.child("Location").getValue(String.class);
                    jobTitle = ds.child("Title").getValue(String.class);
                    pay = "$" + ds.child("Pay").getValue(String.class);

                    if(location != null) {
                        getCoordinatesFromAddress(location);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
