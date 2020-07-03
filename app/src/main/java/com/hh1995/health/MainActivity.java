package com.hh1995.health;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    TabLayout tabLayout;
    MyAdapter adapter;
    ViewPager pager;

    FrameLayout frameLayout;

    TimerFragment timerFragment;
    RoutineFragment routineFragment;
    YoutubeFragment youtubeFragment;

    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);

        drawerLayout = findViewById(R.id.drawer);


        pager = findViewById(R.id.pager);
        adapter = new MyAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);

        frameLayout = findViewById(R.id.container);
        timerFragment = new TimerFragment();
        routineFragment= new RoutineFragment();
        youtubeFragment= new YoutubeFragment();



        BottomNavigationView bottomNavigationView = findViewById(R.id.botnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.timer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, timerFragment).addToBackStack(null).commit();

                        return true;

                    case R.id.routine:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, routineFragment).addToBackStack(null).commit();
                        return true;

                    case R.id.youSearch:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, youtubeFragment).addToBackStack(null).commit();
                        return true;

                };
                    return false;
            }
        });


    }


}
