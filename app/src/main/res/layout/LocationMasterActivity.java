package com.example.vms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class LocationMasterActivity extends AppCompatActivity {

    private ListView listView;
    private Button addLocationButton;
    private ArrayList<HashMap<String, String>> locationList;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_master);

        listView = findViewById(R.id.locationListView);
        addLocationButton = findViewById(R.id.addLocationButton);

        // Hardcoded Location Data
        locationList = new ArrayList<>();

        HashMap<String, String> location1 = new HashMap<>();
        location1.put("LocationId", "1");
        location1.put("LocationName", "Manipal");
        location1.put("status", "Active");
        locationList.add(location1);

        addLocationButton.setOnClickListener(v -> {
            Intent intent = new Intent(LocationMasterActivity.this, AddLocationActivity.class);
            startActivity(intent);
        });
        // Adapter for ListView
        adapter = new SimpleAdapter(
                this, locationList, R.layout.list_item_company,
                new String[]{"LocationId", "LocationName", "status"},
                new int[]{R.id.textCompanyId, R.id.textCompanyName, R.id.textStatus}
        );

        listView.setAdapter(adapter);

    }
}
