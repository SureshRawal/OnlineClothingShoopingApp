package com.example.onlineclothingshoppingapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import Adapter.ViewPagerAdapter;
import fragment.LoginFragment;
import fragment.RegisterFragment;

public class LoginRegisterActivity extends AppCompatActivity {
    private ViewPager viewPagerHome;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        viewPagerHome = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabId);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(),"Login");
        adapter.addFragment(new RegisterFragment(),"Register");

        viewPagerHome.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPagerHome);
    }
}