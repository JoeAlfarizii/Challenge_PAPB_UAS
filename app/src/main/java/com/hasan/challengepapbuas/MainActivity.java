package com.hasan.challengepapbuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.ui_content);
        tabAdapter tAdapter = new tabAdapter(getSupportFragmentManager());
        tAdapter.addFragment(new fragment_main(), "Main");
        tAdapter.addFragment(new fragment_history(), "History");
        pager.setAdapter(tAdapter);
        TabLayout tab_layout = findViewById(R.id.tabs);
        tab_layout.setupWithViewPager(pager);
    }
}