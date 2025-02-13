package com.example.vms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddLocationActivity extends AppCompatActivity {

    private EditText locationIdInput, locationNameInput;
    private Spinner statusSpinner;
    private Button saveButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        locationIdInput = findViewById(R.id.locationIdInput);
        locationNameInput = findViewById(R.id.locationNameInput);
        statusSpinner = findViewById(R.id.statusSpinner);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        // Save Button Click Listener
        saveButton.setOnClickListener(v -> {
            String locationId = locationIdInput.getText().toString();
            String locationName = locationNameInput.getText().toString();
            String status = statusSpinner.getSelectedItem().toString();

            if (!locationId.isEmpty() && !locationName.isEmpty()) {
                Toast.makeText(this, "Location Added: " + locationName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
        });

        // Back Button Click Listener
        backButton.setOnClickListener(v -> finish());
    }
}
