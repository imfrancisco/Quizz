package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private EditText mEditText_name, mEditText_lastName, mEditText_email, mEditText_dateOfBirth, mEditText_username, mEditText_password, mEditText_confirmPassword;
    private Button mButton_register;
    private TextView mTextView_login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEditText_name = (EditText)findViewById(R.id.editText_name);
        mEditText_lastName = (EditText)findViewById(R.id.editText_lastName);
        mEditText_email = (EditText)findViewById(R.id.editText_email);
        mEditText_dateOfBirth = (EditText)findViewById(R.id.editText_dateOfBirth);
        mEditText_username = (EditText)findViewById(R.id.editText_username);
        mEditText_password = (EditText)findViewById(R.id.editText_password);
        mEditText_confirmPassword = (EditText)findViewById(R.id.editText_confirmPassword);
        mButton_register = (Button)findViewById(R.id.button_register);
        mTextView_login = (TextView)findViewById(R.id.textView_login);

        mButton_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateName();
                validateLastName();
                validateEmail();
                validateDateOfBirth();
                validateUserName();
                validatePassword();
                validateConfirmPassword();
                if(TextUtils.isEmpty(mEditText_name.getText().toString()) || TextUtils.isEmpty(mEditText_lastName.getText().toString()) ||
                        TextUtils.isEmpty(mEditText_email.getText().toString()) || TextUtils.isEmpty(mEditText_dateOfBirth.getText().toString()) ||
                        TextUtils.isEmpty(mEditText_username.getText().toString()) || TextUtils.isEmpty(mEditText_password.getText().toString()) || TextUtils.isEmpty(mEditText_confirmPassword.getText().toString())){
                    Toast.makeText(Register.this,"Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(validateName() && validateLastName() && validateEmail() && validateDateOfBirth() && validateUserName() && validatePassword() && validateConfirmPassword()){
                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mTextView_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Register.this, Login.class);
                startActivity(loginIntent);
            }
        });
    }

    // This method will validate name
    public boolean validateName(){
        String nameInput = mEditText_name.getText().toString().trim();
        if(!NAME_VALIDATION.matcher(nameInput).matches()) {
            mEditText_name.setError("Please enter a valid name");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate last name
    public static final Pattern NAME_VALIDATION = Pattern.compile("[a-zA-z\\s]{3,30}");

    // This method will validate name
    public boolean validateLastName(){
        String LastNameInput = mEditText_lastName.getText().toString().trim();
        if(!LASTNAME_VALIDATION.matcher(LastNameInput).matches()) {
            mEditText_lastName.setError("Please enter a valid last name");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate last name
    public static final Pattern LASTNAME_VALIDATION = Pattern.compile("[a-zA-z\\s]{3,30}");


    // This method will validate email
    protected boolean validateEmail(){
        String emailInput = mEditText_email.getText().toString().trim();
        if(!EMAIL_ADDRESS.matcher(emailInput).matches()) {
            mEditText_email.setError("Please enter a valid email address");
            return false;
        }
        else{
            return true;
        }
    }

    // This is the pattern to validate Email
    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");


    // This method will validate the date of Birth
    public boolean validateDateOfBirth(){
        String dateOfBirthInput = mEditText_dateOfBirth.getText().toString().trim();
        if(!DATE_OF_BIRTH_VALIDATION.matcher(dateOfBirthInput).matches()) {
            mEditText_dateOfBirth.setError("Please enter mm/dd/yyyy");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate the date of birth
    public static final Pattern DATE_OF_BIRTH_VALIDATION = Pattern.compile("^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$");

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

    // This is the pattern to validate last name
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

    // This method will validate the password
    public boolean validateConfirmPassword(){
        String confirmPasswordInput = mEditText_confirmPassword.getText().toString().trim();
        if(!PASSWORD_VALIDATION.matcher(confirmPasswordInput).matches()) {
            mEditText_confirmPassword.setError("Password too weak");
            return false;
        }
        else {
            return true;
        }
    }
}
