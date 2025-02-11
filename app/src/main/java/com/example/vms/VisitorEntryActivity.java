package com.example.vms;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VisitorEntryActivity extends AppCompatActivity {

    private EditText visitorNameInput, placeInput, companyNameInput, designationInput,
            visitingPurposeInput, visitingStaffInput, approverNameInput,
            securityPersonnelName, securityIdInput;
    private Spinner visitorTypeSpinner, idProofSpinner;
    private Button uploadFileButton, submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_entry);

        // Initialize Views
        visitorNameInput = findViewById(R.id.visitor_name_input);
        placeInput = findViewById(R.id.place_input);
        companyNameInput = findViewById(R.id.company_name_input);
        designationInput = findViewById(R.id.designation_input);
        visitingPurposeInput = findViewById(R.id.visiting_purpose_input);
        visitingStaffInput = findViewById(R.id.visiting_staff_input);
        approverNameInput = findViewById(R.id.approver_name_input);
        securityPersonnelName = findViewById(R.id.security_personnel_name);
        securityIdInput = findViewById(R.id.security_id_input);

        visitorTypeSpinner = findViewById(R.id.visitor_type_spinner);
        idProofSpinner = findViewById(R.id.id_proof_spinner);
        uploadFileButton = findViewById(R.id.upload_file_button);
        submitButton = findViewById(R.id.submit_button);

        // Set up Spinner Data
        setupSpinners();

        // Handle Form Submission
        submitButton.setOnClickListener(v -> {
            String visitorName = visitorNameInput.getText().toString();
            String selectedVisitorType = visitorTypeSpinner.getSelectedItem().toString();

            if (visitorName.isEmpty()) {
                Toast.makeText(this, "Visitor Name is required", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Visitor Entry Submitted for " + visitorName +
                        " (" + selectedVisitorType + ")", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Upload Button Click
        uploadFileButton.setOnClickListener(v ->
                Toast.makeText(this, "File upload button clicked!", Toast.LENGTH_SHORT).show()
        );
    }

    private void setupSpinners() {
        // Data for Spinners
        String[] visitorTypes = {"Official", "Vendor", "Guest", "Employee"};
        String[] idProofTypes = {"Aadhar Card", "Driving License", "Passport", "PAN Card"};

        // Setup Visitor Type Spinner
        ArrayAdapter<String> visitorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, visitorTypes);
        visitorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitorTypeSpinner.setAdapter(visitorAdapter);

        // Setup ID Proof Spinner
        ArrayAdapter<String> idProofAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idProofTypes);
        idProofAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idProofSpinner.setAdapter(idProofAdapter);
    }
}
