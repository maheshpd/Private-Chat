package com.arfeenkhan.privatechat;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arfeenkhan.privatechat.adapter.WalkthroughPagerAdapter;

public class Walkthrough extends AppCompatActivity {

    private ViewPager mPager;
    private int[] layout = {R.layout.first_slider, R.layout.second_slider, R.layout.third_slider};
    private WalkthroughPagerAdapter walkthroughPagerAdapter;

    private LinearLayout dots_layout;
    private ImageView[] dots;

    private Button got_it_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        if (new PreferenceManager(this).checkPreference()) {
            loadOptionActivity();
        }


        mPager = findViewById(R.id.viewPager);
        got_it_btn = findViewById(R.id.btn_gotit);


        walkthroughPagerAdapter = new WalkthroughPagerAdapter(layout, this);
        mPager.setAdapter(walkthroughPagerAdapter);

        dots_layout = findViewById(R.id.dotsLayout);
        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                createDots(i);
                if (i == layout.length - 1) {
                    got_it_btn.setText("Start");
                    got_it_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loadOptionActivity();
//                            new PreferenceManager(this).writePreference();
                            new PreferenceManager(getApplicationContext()).writePreference();
                        }
                    });
                }
                else {
                    got_it_btn.setText("Got it");
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        got_it_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextSlider();
            }
        });
    }

    private void loadOptionActivity() {
        startActivity(new Intent(Walkthrough.this, OptionActivity.class));
        finish();
    }

    private void createDots(int current_position) {
        if (dots_layout != null) {
            dots_layout.removeAllViews();
            dots = new ImageView[layout.length];

            for (int i = 0; i < layout.length; i++) {
                dots[i] = new ImageView(this);

                if (i == current_position) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
                } else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dot));
                }

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4, 0, 4, 0);
                dots_layout.addView(dots[i], params);
            }
        }
    }

    private void loadNextSlider() {
        int next_slider = mPager.getCurrentItem() + 1;

        if (next_slider < layout.length) {
            mPager.setCurrentItem(next_slider);
        } else {
            loadOptionActivity();
            new PreferenceManager(this).writePreference();
        }
    }

}
