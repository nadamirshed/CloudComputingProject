package com.example.cloudcomputingproject.Doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cloudcomputingproject.Patient.adapter.ProfileActivity;
import com.example.cloudcomputingproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DoctorHome extends AppCompatActivity {
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorHome.this, AddTopic.class);
                startActivity(intent);
            }
        });

        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.homeDoctor);

        nav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeDoctor:
                    return true;
                case R.id.profileDoctor:
                    startActivity(new Intent(DoctorHome.this, ProfileDoctor.class));
                    return true;
                case R.id.notificationDoctor:
                    startActivity(new Intent(DoctorHome.this, NotificationDoctor.class));
                    return true;
                case R.id.trackDoctor:
                    startActivity(new Intent(DoctorHome.this, TrackDoctor.class));
                    return true;
                default:
                    return false;
            }
        });
    }
}