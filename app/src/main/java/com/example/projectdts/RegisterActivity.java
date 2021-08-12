package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class RegisterActivity extends AppCompatActivity {
    EditText txtUsername, txtEmail, txtPassword;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        txtUsername = findViewById(R.id.edt_txt_username);
        txtEmail = findViewById(R.id.edt_txt_email);
        txtPassword = findViewById(R.id.edt_txt_password);
    }

    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void postSignUp(View view) {
        String username, password, email;
        username = txtUsername.getText().toString();
        password = txtPassword.getText().toString();
        email = txtEmail.getText().toString();

        if (username.isEmpty() && email.isEmpty() && password.isEmpty()){
            Toast.makeText(view.getContext(), "Fill the blank!",
                    Toast.LENGTH_LONG).show();
        } else if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(view.getContext(), "Please complete your data!",
                    Toast.LENGTH_LONG).show();
        } else if (!isValidEmail(email)) {
            Toast.makeText(view.getContext(), "Invalid email!",
                    Toast.LENGTH_LONG).show();
        } else  if (password.length() < 6){
            Toast.makeText(view.getContext(), "Minimum password length is 6 characters!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(view.getContext(), "Sign Up Success!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, RecyclerViewDetailActivity.class);
            startActivity(i);
        }
    }

    public void postLoginNow(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}