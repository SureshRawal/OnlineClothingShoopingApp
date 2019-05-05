package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Adapter.ClothAdapter;
import Model.Cloth;


public class DashboardActivity extends AppCompatActivity {
    private RecyclerView rcClothes;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rcClothes = findViewById(R.id.rvClothes);
        btnAdd = findViewById(R.id.btnAdd);

        List<Cloth> clothList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = openFileInput("item.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                String[] parts=line.split("->");

                int cloth_image= getResources().getIdentifier(parts[2],"drawable",getPackageName());
                clothList.add(new Cloth(parts[0],parts[1],cloth_image,parts[3]));
            }

            ClothAdapter clothadapter = new ClothAdapter(this,clothList);
            rcClothes.setAdapter(clothadapter);
            rcClothes.setLayoutManager(new GridLayoutManager(this,2));


        }  catch (IOException e) {
            e.printStackTrace();
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashboardActivity.this, AddItemActivity.class);
                startActivity(intent);

            }
        });


    }
}