package com.example.vms;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DailyVisitorListActivity extends AppCompatActivity {

    private EditText visitDateFrom, visitDateTo;
    private Spinner visitorTypeSpinner, exitStatusSpinner;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_visitor_list);

        visitDateFrom = findViewById(R.id.visitDateFrom);
        visitDateTo = findViewById(R.id.visitDateTo);
        visitorTypeSpinner = findViewById(R.id.visitorTypeSpinner);
        exitStatusSpinner = findViewById(R.id.exitStatusSpinner);
        searchButton = findViewById(R.id.searchButton);

        // Set default date to today
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(Calendar.getInstance().getTime());
        visitDateFrom.setText(currentDate);
        visitDateTo.setText(currentDate);

        // Open DatePickerDialog when clicking date fields
        visitDateFrom.setOnClickListener(v -> showDatePicker(visitDateFrom));
        visitDateTo.setOnClickListener(v -> showDatePicker(visitDateTo));

        // Populate Visitor Type Spinner
        String[] visitorTypes = {"--Select--", "Visitor", "Customer", "External Auditor",
                "Guest", "Internship", "Interviewee", "Service Provider",
                "Staff", "Supplier", "VIP"};
        ArrayAdapter<String> visitorTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, visitorTypes);
        visitorTypeSpinner.setAdapter(visitorTypeAdapter);

        // Populate Exit Status Spinner
        String[] exitStatusOptions = {"Both", "Yes", "No"};
        ArrayAdapter<String> exitStatusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, exitStatusOptions);
        exitStatusSpinner.setAdapter(exitStatusAdapter);
    }

    private void showDatePicker(EditText dateField) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> {
                    String selectedDate = String.format(Locale.getDefault(), "%02d-%02d-%04d", dayOfMonth, (month + 1), year);
                    dateField.setText(selectedDate);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePicker.show();
    }
}
