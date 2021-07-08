package com.leobilha.covinfo.linhadotempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leobilha.covinfo.R;

public class LinhaDoTempo extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mLinearLayout;

    private TextView[] mDots;

    private AdapterLinhaDoTempo adapterLinhaDoTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linha_do_tempo);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mLinearLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        adapterLinhaDoTempo = new AdapterLinhaDoTempo(this);

        mSlideViewPager.setAdapter(adapterLinhaDoTempo);

        addDotsIndicator(0);

        mSlideViewPager.setOnPageChangeListener(viewListener);


    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[27];

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.cardDicas));

            mLinearLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
