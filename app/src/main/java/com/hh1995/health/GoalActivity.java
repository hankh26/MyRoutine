package com.hh1995.health;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GoalActivity extends AppCompatActivity {

    EditText etweigh;
    EditText ettall;
    EditText etfatRate;
    EditText etfatWei;
    EditText etmuscle;
    EditText etvisceralFat;
    EditText etlegMuscle;
    EditText etbasal;

    int imgRequestCode =10;

    ImageView iv;

    Button btn;

    T1Fragment t1Fragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        etweigh=findViewById(R.id.et_weigh);
        ettall=findViewById(R.id.et_tall);
        etfatRate=findViewById(R.id.et_fat);
        etfatWei=findViewById(R.id.et_fatk);
        etmuscle=findViewById(R.id.et_muscle);
        etvisceralFat=findViewById(R.id.et_infat);
        etlegMuscle=findViewById(R.id.et_legMuscle);
        etbasal=findViewById(R.id.et_energy);

        iv=findViewById(R.id.goalIv);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);

            }
        }

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String weigh=etweigh.getText().toString();
                String tall=ettall.getText().toString();
                String fatRate=etfatRate.getText().toString();
                String fatWei=etfatWei.getText().toString();
                String muscle=etmuscle.getText().toString();
                String visceralFat=etvisceralFat.getText().toString();
                String legMuscle=etlegMuscle.getText().toString();
                String basal=etbasal.getText().toString();

//                t1Fragment=new T1Fragment();
//                Intent intent=new Intent(GoalActivity.this,MainActivity.class);
//                intent.putExtra("weigh",weigh);
//                startActivity(intent);
//                finish();


//                FirebaseDatabase db=FirebaseDatabase.getInstance();
//                DatabaseReference rootRef=db.getReference();
//
//                Goal goal=new Goal(weigh,tall,fatRate,fatWei,muscle,visceralFat,legMuscle,basal);
//                DatabaseReference goalRef=rootRef.child("goal");
//                goalRef.push().setValue(goal);
//
//
//
//                goalRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        for (DataSnapshot snapshot:dataSnapshot.getChildren()){
//                            Goal goal=snapshot.getValue(Goal.class);
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });

            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 100:
                if (grantResults[0] ==PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "앱을 사용할수 없습니다", Toast.LENGTH_SHORT).show();
                    finish();

                }
                break;
        }

    }


    public void clickImg(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,imgRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10 && resultCode == RESULT_OK) {
            Uri uri=data.getData();
            if (uri != null) {
                Glide.with(this).load(uri).into(iv);
            }
        }
    }
}
