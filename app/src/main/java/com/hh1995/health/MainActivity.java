package com.hh1995.health;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

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

    FragmentManager fragmentManager;
    T1Fragment t1Fragment;
    LinearLayout linearLayout;

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




        BottomNavigationView bottomNavigationView = findViewById(R.id.botnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.timer:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container, timerFragment).addToBackStack(null).commit();
                        Intent intent=new Intent(MainActivity.this,TimeActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.routine:
                       // getSupportFragmentManager().beginTransaction().replace(R.id.container, routineFragment).addToBackStack(null).commit();
                        Intent intent2=new Intent(MainActivity.this,RoutineActivity.class);
                        startActivity(intent2);
                        return true;

                    case R.id.youSearch:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container, youtubeFragment).addToBackStack(null).commit();
                        Intent intent3=new Intent(Intent.ACTION_VIEW);
                        intent3.setData(Uri.parse("https://www.youtube.com/"));
                        intent3.setPackage("com.google.android.youtube");
                        startActivity(intent3);	// do not edit

                };
                    return false;
            }
        });

//        //========================
//        FragmentTransaction transaction =fragmentManager.beginTransaction();
//        //T1Fragment t1Fragment=fragmentManager.findFragmentById(R.id.)
//
//        fragmentManager=getSupportFragmentManager();
//        linearLayout=findViewById(R.id.ll);
//
//        Intent intent= getIntent();
//        String weigh=intent.getStringExtra("weigh");
//
//        Bundle bundle=new Bundle();
//        bundle.putString("weigh",weigh);
//        t1Fragment.setArguments(bundle);
//
//        transaction.add(R.id.ll,t1Fragment);
//
//        transaction.addToBackStack(null);
//        transaction.commit();

    }


}
