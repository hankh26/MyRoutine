package com.hh1995.health;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class T1Fragment extends Fragment {

    ArrayList<Item> items=new ArrayList<>();
    ItemAdater adater;
    RecyclerView recyclerView;
    FloatingActionButton myBtn;

    FloatingActionButton goalBtn;
    int goalRequestCode=100;
    int myRequestCode=101;

    TextView tvWei;
    TextView tvFat;
    TextView tvMus;

    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_1,container,false);


        items.add(new Item(R.drawable.bazzi,"20200701","체중","체지방률","근육량","75kg","11%","38kg"));
        items.add(new Item(R.drawable.dao,"20200701","체중","체지방률","근육량","74kg","10%","38kg"));
        items.add(new Item(R.drawable.dizni,"20200701","체중","체지방률","근육량","73kg","9%","38kg"));

        tvFat=v.findViewById(R.id.tv_fat);
        tvWei=v.findViewById(R.id.tv_weigh);
        tvMus=v.findViewById(R.id.tv_muscle);

//        Bundle bundle=getArguments();
//        if (bundle!=null){
//            String weigh=bundle.getString("weigh");
//            tvWei.setText(weigh);
//        }


        myBtn=v.findViewById(R.id.float_mybtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),MyOptionActivity.class);
                startActivity(intent);

            }
        });
        goalBtn=v.findViewById(R.id.float_goalbtn);
        goalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),GoalActivity.class);
                startActivity(intent);
            }
        });


        recyclerView=v.findViewById(R.id.recycler);
        adater=new ItemAdater(items,getContext());
        recyclerView.setAdapter(adater);




        return v;
    }


}
