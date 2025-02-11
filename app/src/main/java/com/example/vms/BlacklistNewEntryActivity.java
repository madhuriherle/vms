package com.example.vms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BlacklistNewEntryActivity extends AppCompatActivity {

    Spinner gateDropdown;
    EditText visitorNameInput, mobileNumberInput, reasonInput;
    Button backButton, saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blacklist_new_entry);

        // Initialize UI components
        gateDropdown = findViewById(R.id.gateDropdown);
        visitorNameInput = findViewById(R.id.visitorNameInput);
        mobileNumberInput = findViewById(R.id.mobileNumberInput);
        reasonInput = findViewById(R.id.reasonInput);
        backButton = findViewById(R.id.backButton);
        saveButton = findViewById(R.id.saveButton);

        // Setup Dropdown for Gates
        ArrayAdapter<String> gateAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[]{"Main Gate", "VIP Gate"});
        gateDropdown.setAdapter(gateAdapter);

        // Back Button functionality
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(BlacklistNewEntryActivity.this, BlacklistActivity.class);
            startActivity(intent);
            finish(); // Close this activity
        });

        // Save Button functionality
        saveButton.setOnClickListener(v -> {
            String name = visitorNameInput.getText().toString().trim();
            String mobileNumber = mobileNumberInput.getText().toString().trim();
            String reason = reasonInput.getText().toString().trim();

            if (name.isEmpty() || mobileNumber.isEmpty() || reason.isEmpty()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Details saved successfully!", Toast.LENGTH_SHORT).show();
                // Mock: Save data logic can go here, such as saving to database
                visitorNameInput.setText("");
                mobileNumberInput.setText("");
                reasonInput.setText("");
            }
        });
    }
}

