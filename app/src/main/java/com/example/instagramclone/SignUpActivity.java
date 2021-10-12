package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText etUsername_signup;
    private EditText etPassword_signup;
    private Button btnSignUp_signup;
    //private ImageView ins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //ins.findViewById(R.id.ins);
        etUsername_signup = findViewById(R.id.etUsername_signup);
        etPassword_signup = findViewById(R.id.etPassword_signup);
        btnSignUp_signup = findViewById(R.id.btnSignUp_signup);


        btnSignUp_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick Sign Up button");
                String username = etUsername_signup.getText().toString();
                String password = etPassword_signup.getText().toString();
                SignUpUser(username, password);
            }
        });

    }

    private void SignUpUser(String username, String password) {
        Log.i(TAG, "Attempting to Sign up an user"+username);
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    Toast.makeText(SignUpActivity.this,"Sign Up succeed.",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    if(username.isEmpty()){
                        Toast.makeText(SignUpActivity.this,"Username cannot be empty.",Toast.LENGTH_SHORT).show();
                    }
                    else if(password.isEmpty()){
                        Toast.makeText(SignUpActivity.this,"Password cannot be empty.",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(SignUpActivity.this,"Username Existed.",Toast.LENGTH_SHORT).show();
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }
}