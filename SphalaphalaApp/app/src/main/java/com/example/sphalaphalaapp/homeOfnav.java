package com.example.sphalaphalaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homeOfnav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
DrawerLayout drawer;
ActionBarDrawerToggle act;
Toolbar toolbar;
NavigationView nav;
FragmentManager fragmentManager;
FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer=findViewById(R.id.drow);
        nav=findViewById(R.id.na);
        nav.setNavigationItemSelectedListener(this);

        act =new ActionBarDrawerToggle(this, drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(act);
        act.setDrawerIndicatorEnabled(true);
        act.syncState();
        //load default fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,
                new ProfileFragment()).commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedfragement=null;
drawer.closeDrawer(GravityCompat.START);
        switch(menuItem.getItemId()){
           case R.id.nav_profile:
               selectedfragement=new ProfileFragment();
               break;
            case R.id.nav_loc:
                selectedfragement=new LocationFragment();
                break;
            case R.id.nav_contact:
                selectedfragement=new ContactFragment();
                break;
            case R.id.nav_news:
                selectedfragement=new NewsFragment();
                break;
              case R.id.nav_faq:
                selectedfragement=new FAQsFragment();
                break;
              case R.id.nav_loguot:
                selectedfragement=new LogoutFragment();
                break;
        }
      getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,
               selectedfragement).commit();
        return true;
    };
}