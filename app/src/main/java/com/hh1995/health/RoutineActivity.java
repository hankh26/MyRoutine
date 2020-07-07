package com.hh1995.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.zip.Inflater;

public class RoutineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);


    }

    public void clickPlus(View view) {
        Intent intent=new Intent(RoutineActivity.this,RoutineoptionActivity.class);
        startActivity(intent);
    }
}
