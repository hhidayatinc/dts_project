package com.example.projectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsername, txtPasssword;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        txtUsername = findViewById(R.id.edt_txt_email);
        txtPasssword = findViewById(R.id.edt_txt_password);

    }

    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void postLogin(View view) {
        String username = txtUsername.getText().toString();
        String password = txtPasssword.getText().toString();
        if (username.isEmpty() && password.isEmpty()){
            Toast.makeText(view.getContext(), "Fill the blank!",
                    Toast.LENGTH_LONG).show();
        } else if (username.isEmpty()) {
            Toast.makeText(view.getContext(), "Email cannot be empty!", Toast.LENGTH_LONG).show();
        } else if (!isValidEmail(username)) {
            Toast.makeText(view.getContext(), "Invalid email!", Toast.LENGTH_LONG).show();
        } else if (password.isEmpty()){
            Toast.makeText(view.getContext(), "Password cannot be empty!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Login Success! Welcome! ", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, RecylerViewActivity.class);
            startActivity(i);
        }
    }

    public void postRegister(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}