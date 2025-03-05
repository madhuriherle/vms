package com.example.vms;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            // Handle Forgot Password Click
            findViewById(R.id.tvForgotPassword).setOnClickListener(view -> {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            });

            // Handle Login Button Click
            findViewById(R.id.btnLogin).setOnClickListener(view -> {
                // Add login logic here (e.g., authentication)
                // If successful, navigate to MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }






