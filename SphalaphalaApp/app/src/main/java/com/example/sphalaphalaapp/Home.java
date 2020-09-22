package com.example.sphalaphalaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.support.v4.app.*;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //load default fragment
        BottomNavigationView btmNav=findViewById(R.id.bottom_nav);
        btmNav.setOnNavigationItemSelectedListener(navListenr);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListenr=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                   Fragment selectedfragement=null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedfragement=new HomeFragment();
                            break;
                        case R.id.nav_appointment:
                            selectedfragement=new AppointmentFragment();
                            break;
                        case R.id.nav_promotion:
                            selectedfragement=new PromotionFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                            selectedfragement).commit();
                    return true;
                }
            };
}