package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionActivity extends AppCompatActivity {
    CircleImageView imgCloth;
    TextView tvName,tvPrice,tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imgCloth = findViewById(R.id.imgCloth);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDescription = findViewById(R.id.tvDesciption);


        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            imgCloth.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvPrice.setText("Nrs. "+bundle.getString("price"));
            tvDescription.setText(bundle.getString("desc"));

        }
    }
}