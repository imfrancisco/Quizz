package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText mEditText_username, mEditText_password;
    private TextView mTextView_register;
    private Button mButton_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditText_username = (EditText)findViewById(R.id.editText_username);
        mEditText_password = (EditText)findViewById(R.id.editText_password);
        mTextView_register = (TextView)findViewById(R.id.textView_register);
        mButton_Login = (Button)findViewById(R.id.button_login);

        mTextView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
            }
        });

        mButton_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUserName();
                validatePassword();
                if(TextUtils.isEmpty(mEditText_username.getText().toString()) || TextUtils.isEmpty(mEditText_password.getText().toString())){
                    Toast.makeText(Login.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    Intent Intent = new Intent(Login.this, Quiz_Activity.class);
                    startActivity(Intent);
                }
            }
        });
    }

    // This method will validate username
    public boolean validateUserName(){
        String userNameInput = mEditText_username.getText().toString().trim();
        if(!USERNAME_VALIDATION.matcher(userNameInput).matches()) {
            mEditText_username.setError("Please enter a valid username");
            return false;
        }
        else {
            return true;
        }
    }

    public static final Pattern USERNAME_VALIDATION = Pattern.compile("[a-zA-z\\s]{3,30}");

    // This method will validate the password
    public boolean validatePassword(){
        String passwordInput = mEditText_password.getText().toString().trim();
        if(!PASSWORD_VALIDATION.matcher(passwordInput).matches()) {
            mEditText_password.setError("Password too weak");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate the password
    public static final Pattern PASSWORD_VALIDATION = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{1,}");

}
