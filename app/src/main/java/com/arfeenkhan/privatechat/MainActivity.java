package com.arfeenkhan.privatechat;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    //Widget
    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout mTab;
    private TabsAccessorAdapter mytabAccessprAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize widget
        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Private Chat");

        myViewPager = findViewById(R.id.main_tabs_pager);
        mytabAccessprAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(mytabAccessprAdapter);

        mTab = findViewById(R.id.main_tab);
        mTab.setupWithViewPager(myViewPager);

    }
}
