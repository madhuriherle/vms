package com.example.vms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Handle Reset Password Button Click
        findViewById(R.id.btnResetPassword).setOnClickListener(view -> {
            // Add logic for password reset (e.g., send email)
            // Simulate success (for now)
            Toast.makeText(ForgotPasswordActivity.this, "Password reset link sent!", Toast.LENGTH_SHORT).show();

            // Redirect back to LoginActivity
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // Handle Back to Login Click
        findViewById(R.id.tvBackToLogin).setOnClickListener(view -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
