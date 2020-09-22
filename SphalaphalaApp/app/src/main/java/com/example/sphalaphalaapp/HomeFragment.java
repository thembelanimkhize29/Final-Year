package com.example.sphalaphalaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {
    DrawerLayout drawer;
    ActionBarDrawerToggle act;
    Toolbar toolbar;
    NavigationView nav;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
     public class homeOfnav extends AppCompatActivity {
        DrawerLayout drawer;
        ActionBarDrawerToggle act;
        Toolbar toolbar;
        NavigationView nav;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_home);
            toolbar=findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            drawer=findViewById(R.id.drow);
            nav=findViewById(R.id.na);

            act =new ActionBarDrawerToggle(this, drawer,toolbar,R.string.open,R.string.close);
            drawer.addDrawerListener(act);
            act.setDrawerIndicatorEnabled(true);
            act.syncState();
        }}
}
