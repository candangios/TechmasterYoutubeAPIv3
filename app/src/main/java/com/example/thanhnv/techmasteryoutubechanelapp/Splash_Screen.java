package com.example.thanhnv.techmasteryoutubechanelapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {
//    create logo
    private ImageView img;
    private  boolean mIsBackButtonPreaaed;
    private  static final int SPLASH_DURATION = 2000; // 3seconds




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_screen);
        //anh sa image toi file spash_screen.xml.
        img = (ImageView)findViewById(R.id.img);
        // chay animation
        animation();
        // tao mot su kien delay Splash_duration
        Handler handler = new Handler();

        Runnable r = new Runnable() {
            public void run() {
                if (!mIsBackButtonPreaaed) {
                    Intent i = new Intent(Splash_Screen.this, MainActivity.class);
                    finish();
                    startActivity(i);
                    // bo hieu ung chuyen sang mot view khac.
                    overridePendingTransition(0,0);


                }
            }
        };
        handler.postDelayed(r,SPLASH_DURATION);
    }
    private void animation(){
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(img, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(img, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(img, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
//        animatorSet.setStartDelay(500);
        animatorSet.start();
//tạo một animation


    }


}
