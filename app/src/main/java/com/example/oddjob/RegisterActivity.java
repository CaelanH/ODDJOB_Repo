package com.example.oddjob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{
    private EditText mFirstName, mLastName, mPhone, mEmail, mAddress, mAddressLine2, mPostal, mPassword;
    private FirebaseAuth mAuth;
    private Button mAcceptButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAcceptButton = findViewById(R.id.login_button);
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
                writeToDatabase(mFirstName, mLastName,mPhone, mEmail, mAddress, mAddressLine2, mPostal, mPassword);
            }
        });
    }
    private void writeToDatabase(EditText mFirstName, EditText mLastName, EditText mPhone, EditText mEmail, EditText mAddress, EditText mAddressLine2, EditText mPostal, EditText mPassword){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
    }
    public void createAccount(){
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
}