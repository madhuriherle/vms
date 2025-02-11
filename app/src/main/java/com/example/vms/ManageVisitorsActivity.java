package com.example.vms;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ManageVisitorsActivity extends AppCompatActivity {

    private Spinner gateSpinner, exitStatusSpinner;
    private Button dateButton, searchButton;
    private EditText visitorNameInput, mobileNumberInput;
    private TextView selectedDateTextView;

    private final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_visitors);

        // Initialize views
        gateSpinner = findViewById(R.id.gateSpinner);
        dateButton = findViewById(R.id.dateButton);
        visitorNameInput = findViewById(R.id.visitorNameInput);
        mobileNumberInput = findViewById(R.id.mobileNumberInput);
        exitStatusSpinner = findViewById(R.id.exitStatusSpinner);
        searchButton = findViewById(R.id.searchButton);

        // Set up Gate Spinner
        String[] gates = {"Main Entrance Gate", "VIP Gate"};
        ArrayAdapter<String> gateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gates);
        gateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gateSpinner.setAdapter(gateAdapter);

        // Set up Exit Status Spinner
        String[] exitStatusOptions = {"Yes", "No", "Both"};
        ArrayAdapter<String> exitStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, exitStatusOptions);
        exitStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exitStatusSpinner.setAdapter(exitStatusAdapter);

        // Set default date to current date
        updateDateButtonText();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gate = gateSpinner.getSelectedItem().toString();
                String date = dateButton.getText().toString();
                String visitorName = visitorNameInput.getText().toString().trim();
                String mobileNumber = mobileNumberInput.getText().toString().trim();
                String exitStatus = exitStatusSpinner.getSelectedItem().toString();

                // Perform search logic
                performSearch(gate, date, visitorName, mobileNumber, exitStatus);
            }
        });
    }

    private void showDatePickerDialog() {
        new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            calendar.set(year, month, dayOfMonth);
            updateDateButtonText();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateDateButtonText() {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        dateButton.setText(sdf.format(calendar.getTime()));
    }

    private void performSearch(String gate, String date, String visitorName, String mobileNumber, String exitStatus) {
        // Display search result or handle query logic
        String message = "Search: Gate=" + gate + ", Date=" + date + ", Visitor=" + visitorName +
                ", Mobile=" + mobileNumber + ", Exit Status=" + exitStatus;
        // Toast or Log for result
    }
}
