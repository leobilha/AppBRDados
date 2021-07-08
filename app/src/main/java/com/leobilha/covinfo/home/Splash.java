package com.leobilha.covinfo.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leobilha.covinfo.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.splashImg);
        TextView textView1 = findViewById(R.id.textCovInfo);
        TextView textView2 = findViewById(R.id.textCarrega);
        ProgressBar progressBar = findViewById(R.id.progress_circular_splash);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_splash);
        imageView.startAnimation(animation);
        textView1.startAnimation(animation);
        textView2.startAnimation(animation);
        progressBar.startAnimation(animation);

        progressBar.setVisibility(View.VISIBLE);

        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(6000);
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }
}
