package com.example.vms;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BlacklistActivity extends AppCompatActivity {

    Spinner gateDropdown;
    EditText mobileNumberInput;
    Button addButton, deleteButton;

    ArrayList<String> blacklistedNumbers;
    ArrayAdapter<String> blacklistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blacklist);

        gateDropdown = findViewById(R.id.gateDropdown);
        mobileNumberInput = findViewById(R.id.mobileNumberInput);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);

        // Setup Dropdown for Gates
        ArrayAdapter<String> gateAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[]{"Main Gate", "VIP Gate"});
        gateDropdown.setAdapter(gateAdapter);

        blacklistedNumbers = new ArrayList<>();

        // Delete button with confirmation dialog
        deleteButton.setOnClickListener(v -> {
            String mobileNumber = mobileNumberInput.getText().toString().trim();

            if (blacklistedNumbers.contains(mobileNumber)) {
                new AlertDialog.Builder(this)
                        .setTitle("Confirm Deletion")
                        .setMessage("Are you sure you want to delete this contact?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            blacklistedNumbers.remove(mobileNumber);
                            mobileNumberInput.setText("");
                            Toast.makeText(this, "Removed from blacklist!", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("No", null)
                        .show();
            } else {
                Toast.makeText(this, "Number not found in blacklist", Toast.LENGTH_SHORT).show();
            }
        });

        addButton.setOnClickListener(v -> {
            String mobileNumber = mobileNumberInput.getText().toString().trim();
            if (isValidMobileNumber(mobileNumber)) {
                if (!blacklistedNumbers.contains(mobileNumber)) {
                    blacklistedNumbers.add(mobileNumber);
                    mobileNumberInput.setText("");
                    Toast.makeText(this, "Added to blacklist!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Number already blacklisted", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter a valid 10-digit number", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidMobileNumber(String number) {
        return !TextUtils.isEmpty(number) && number.matches("\\d{10}");
    }
}
