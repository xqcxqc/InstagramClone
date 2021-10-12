package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignUp;
    //private ImageView ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //if the user has logined before, then just go to the main activity
        if(ParseUser.getCurrentUser() != null){
            goMainActivity();
        }

        //ins.findViewById(R.id.ins);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick Login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick Sign UP button");
                goSignUpActivity();
            }
        });


    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user"+username);

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                //if there is error when login
                if(e !=null){
                    //to do: better error handling
                    Toast.makeText(LoginActivity.this,"Username or Password is wrong!",Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"Issue with Login",e);
                    return;
                }
                //no error.then Navigate to the main activity if the user has signed in properly
                goMainActivity();
                Toast.makeText(LoginActivity.this,"Success login!",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goSignUpActivity() {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        //finish();
    }


}