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

public class CompanyMasterActivity extends AppCompatActivity {

    private ListView listView;
    private Button addCompanyButton;
    private ArrayList<HashMap<String, String>> companyList;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_master);

        listView = findViewById(R.id.companyListView);
        addCompanyButton = findViewById(R.id.addCompanyButton);

        // Hardcoded Company Data
        companyList = new ArrayList<>();

        HashMap<String, String> company1 = new HashMap<>();
        company1.put("companyId", "MCT");
        company1.put("companyName", "MCT Cards & Technology Pvt Ltd");
        company1.put("status", "Active");
        companyList.add(company1);

        HashMap<String, String> company2 = new HashMap<>();
        company2.put("companyId", "MTL");
        company2.put("companyName", "Manipal Technologies Ltd");
        company2.put("status", "Active");
        companyList.add(company2);

        // Adapter for ListView
        adapter = new SimpleAdapter(
                this, companyList, R.layout.list_item_company,
                new String[]{"companyId", "companyName", "status"},
                new int[]{R.id.textCompanyId, R.id.textCompanyName, R.id.textStatus}
        );

        listView.setAdapter(adapter);

        // Button Click - Open Add New Company Page
        addCompanyButton.setOnClickListener(v -> {
            Intent intent = new Intent(CompanyMasterActivity.this, AddCompanyActivity.class);
            startActivity(intent);
        });
    }
}
