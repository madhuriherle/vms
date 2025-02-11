package com.example.vms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddCompanyActivity extends AppCompatActivity {

    private EditText companyIdInput, companyNameInput;
    private Spinner statusSpinner;
    private Button saveButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        companyIdInput = findViewById(R.id.companyIdInput);
        companyNameInput = findViewById(R.id.companyNameInput);
        statusSpinner = findViewById(R.id.statusSpinner);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        // Save Button Click Listener
        saveButton.setOnClickListener(v -> {
            String companyId = companyIdInput.getText().toString();
            String companyName = companyNameInput.getText().toString();
            String status = statusSpinner.getSelectedItem().toString();

            if (!companyId.isEmpty() && !companyName.isEmpty()) {
                Toast.makeText(this, "Company Added: " + companyName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
        });

        // Back Button Click Listener
        backButton.setOnClickListener(v -> finish());
    }
}
