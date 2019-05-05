package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {
    private EditText etClothName, etClothPrice, etImageName, etItemDescription;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etClothName = findViewById(R.id.etClothName);
        etClothPrice = findViewById(R.id.etClothPrice);
        etImageName = findViewById(R.id.etImageName);
        etItemDescription = findViewById(R.id.etDescription);
        btnAdd = findViewById(R.id.btnSave);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    save();
                }
            }
        });
    }

    private boolean validate(){
        boolean validator=true;
        if(TextUtils.isEmpty(etClothName.getText().toString())){
            etClothName.setError(" Name is required");
            etClothName.requestFocus();
            validator=false;
        }
        if(TextUtils.isEmpty(etClothPrice.getText().toString())){
            etClothPrice.setError("Price is required");
            etClothPrice.requestFocus();
            validator=false;
        }
        if(TextUtils.isEmpty(etImageName.getText().toString())){
            etImageName.setError("Image is required");
            etImageName.requestFocus();
            validator=false;
        }
        if(TextUtils.isEmpty(etItemDescription.getText().toString())){
            etItemDescription.setError("Description is required");
            etItemDescription.requestFocus();
            validator=false;
        }


        return  validator;

    }

    private void  save(){
        try{
            PrintStream printStream= new PrintStream(openFileOutput("item.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etClothName.getText().toString()+"->"+etClothPrice.getText().toString()+"->"+etImageName.getText().toString()+"->"+etItemDescription.getText().toString());
            printStream.flush();
            printStream.close();
            Toast.makeText(this,"Item added ",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(AddItemActivity.this,DashboardActivity.class);
            startActivity(intent);
        }catch (IOException e){
            Log.d("Items Add ","Error"+e.toString());
            e.printStackTrace();

        }
    }
}