package com.example.oddjob;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import com.example.oddjob.R;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button mLoginButton;
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextUsername = findViewById(R.id.username_login);
        mEditTextUsername.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        mEditTextPassword = findViewById(R.id.password_login);
        mEditTextPassword.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
