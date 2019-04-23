package com.example.oddjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oddjob.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.support.annotation.NonNull;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity{
    private EditText mFirstName, mLastName, mPhone, mEmail, mAddress, mAddressLine2, mPostal, mPassword;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = mDatabase.getReference("users");
    private Button mAcceptButton;
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAcceptButton = findViewById(R.id.register_button);
        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mPhone = findViewById(R.id.phone);
        mEmail = findViewById(R.id.email);
        mAddress = findViewById(R.id.address);
        mAddressLine2 = findViewById(R.id.addressln2);
        mPostal = findViewById(R.id.postal);
        mPassword = findViewById(R.id.password);
        mAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(mEmail.getText().toString(), mPassword.getText().toString());
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    private void createAccount(String mEmail, String mPassword){
        mAuth.createUserWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userID = user.getUid();
                            writeToDatabase(userID);
                            Intent i = new Intent(RegisterActivity.this, TypeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
    public void writeToDatabase(String userID){
        User user = new User();
        user.setFirstName(mFirstName.getText().toString());
        user.setLastName(mLastName.getText().toString());
        user.setPhone(mPhone.getText().toString());
        user.setEmail(mEmail.getText().toString());
        user.setAddress(mAddress.getText().toString());
        user.setAddressLn2(mAddressLine2.getText().toString());
        user.setPostal(mPostal.getText().toString());
        myRef.child(userID).setValue(user);
        Intent i = new Intent(RegisterActivity.this, TypeActivity.class);
        startActivity(i);
    }
}