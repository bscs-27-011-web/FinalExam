package com.example.labexam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variable names updated to match the student-style IDs
    private EditText userName, userPassword;
    private Spinner Gender, country, City;
    private Button btnAdd;
    private TextView recordC;
    private RecyclerView recyclerView;
    
    private List<User> userList;
    private UserAdapter adapter;
    private int nextId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Views using the new IDs from activity_main.xml
        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        Gender = findViewById(R.id.Gender);
        country = findViewById(R.id.country);
        City = findViewById(R.id.City);
        btnAdd = findViewById(R.id.btnAdd);
        recordC = findViewById(R.id.recordC);
        recyclerView = findViewById(R.id.recyclerView);

        // Setup Spinners
        setupSpinners();

        // Setup RecyclerView
        userList = new ArrayList<>();
        adapter = new UserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Button Click Listener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void setupSpinners() {
        // Gender Spinner
        String[] genders = {"Male", "Female", "Other"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gender.setAdapter(genderAdapter);

        // Province/Country Spinner
        String[] provinces = {"Punjab", "Sindh", "KPK", "Balochistan"};
        ArrayAdapter<String> provinceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, provinces);
        provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(provinceAdapter);

        // City Spinner
        String[] cities = {"Lahore", "Karachi", "Islamabad", "Peshawar", "Quetta"};
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        City.setAdapter(cityAdapter);
    }

    private void addUser() {
        String nameStr = userName.getText().toString().trim();
        String passStr = userPassword.getText().toString().trim();
        String genderStr = Gender.getSelectedItem().toString();
        String provinceStr = country.getSelectedItem().toString();
        String cityStr = City.getSelectedItem().toString();

        if (nameStr.isEmpty() || passStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String loc = cityStr + ", " + provinceStr;
        
        // Create new user with auto-generated ID
        User newUser = new User(nextId++, nameStr, genderStr, passStr, loc);
        
        // Add to list and notify adapter
        userList.add(newUser);
        adapter.notifyDataSetChanged();
        
        // Update record count
        recordC.setText("Records: " + userList.size());

        // Clear input fields
        userName.setText("");
        userPassword.setText("");
        
        Toast.makeText(this, "User added! ID is " + (nextId - 1), Toast.LENGTH_SHORT).show();
    }
}