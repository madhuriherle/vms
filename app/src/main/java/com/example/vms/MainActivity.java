package com.example.vms;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    MenuAdapter menuAdapter;
    List<String> listTitles;
    HashMap<String, List<String>> listDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize ExpandableListView
        expandableListView = findViewById(R.id.expandableListView);
        initMenuData();

        menuAdapter = new MenuAdapter(this, listTitles, listDetails);
        expandableListView.setAdapter(menuAdapter);

        // Handle Click on Sub-options
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String selectedItem = listDetails.get(listTitles.get(groupPosition)).get(childPosition);

            switch (selectedItem) {
                case "Visitor Entry":
                    // Navigate to VisitorEntryActivity
                    Intent visitorEntryIntent = new Intent(MainActivity.this, VisitorEntryActivity.class);
                    startActivity(visitorEntryIntent);
                    break;

                case "Manage Visitor":
                    // Navigate to ManageVisitorsActivity
                    Intent manageVisitorsIntent = new Intent(MainActivity.this, ManageVisitorsActivity.class);
                    startActivity(manageVisitorsIntent);
                    break;
                case "Black List":
                    // Navigate to BlacklistActivity
                    Intent blacklistIntent = new Intent(MainActivity.this, BlacklistActivity.class);
                    startActivity(blacklistIntent);
                    break;
                case "Daily Visitor List":
                    Intent dailyVisitorIntent = new Intent(MainActivity.this, DailyVisitorListActivity.class);
                    startActivity(dailyVisitorIntent);
                    break;
                case "Company Master":
                    // Navigate to CompanyMasterActivity
                    Intent companyMasterIntent = new Intent(MainActivity.this, CompanyMasterActivity.class);
                    startActivity(companyMasterIntent);
                    break;



                default:
                    Toast.makeText(MainActivity.this, selectedItem + " Clicked!", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        });
    }

    // Initialize Admin & User Menu Data
    private void initMenuData() {
        listTitles = new ArrayList<>();
        listDetails = new HashMap<>();

        // Admin Menu Items
        List<String> adminOptions = new ArrayList<>();
        adminOptions.add("Company Master");
        adminOptions.add("Location Master");
        adminOptions.add("Office Master");
        adminOptions.add("Gate Master");
        adminOptions.add("Area Master");
        adminOptions.add("ID Proof Type Master");
        adminOptions.add("Visitor Type Master");
        adminOptions.add("User Master");

        // User Menu Items
        List<String> userOptions = new ArrayList<>();
        userOptions.add("Visitor Entry");  // Trigger this option to navigate
        userOptions.add("Manage Visitor");
        userOptions.add("Black List");
        userOptions.add("Daily Visitor List");

        // Add to Lists
        listTitles.add("Admin");
        listTitles.add("User Menu");
        listDetails.put("Admin", adminOptions);
        listDetails.put("User Menu", userOptions);
    }

    // Setup Profile Dropdown Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the profile_menu.xml
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    // Handle Profile Menu Click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_profile) {
            showProfileDropdown(findViewById(R.id.toolbar));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showProfileDropdown(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenu().add("Profile Settings");
        popup.getMenu().add("Logout");

        popup.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, item.getTitle() + " Clicked!", Toast.LENGTH_SHORT).show();
            return true;
        });

        popup.show();
    }
}