package com.fromzerototaisino.selbststudiumdeutsch.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.fromzerototaisino.selbststudiumdeutsch.R;
import com.fromzerototaisino.selbststudiumdeutsch.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    //Final variables
    private static int SPLASH_TIMER = 5000;

    //Variables
    ImageView bgImg, bgGlass, bgLogo, bgDeutsch;
    TextView txtLogo, txtSlogan;


    //Animations
    Animation topAnim, bottomAnim, imgAppearAnim, txtAppearAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        addControls();
        addEvents();

    }

    private void addControls() {
        //Hooks
        bgDeutsch = findViewById(R.id.background_deutsch);
        bgLogo = findViewById(R.id.background_logo);
        bgImg = findViewById(R.id.background_img_splash);
        bgGlass = findViewById(R.id.background_glass);
        txtLogo = findViewById(R.id.txtLogo);
        txtSlogan = findViewById(R.id.txtSlogan);


        //Animations
        topAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bg_img_top_anim);
        bottomAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bg_img_bottom_anim);
        imgAppearAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bg_glass_appear_anim);
        txtAppearAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bg_txt_appear_anim);

        //Set Animations on Elements
        bgGlass.setAnimation(imgAppearAnim);
        bgDeutsch.setAnimation(topAnim);
        bgLogo.setAnimation(bottomAnim);
        txtLogo.setAnimation(txtAppearAnim);


        //ao
    }

    private void addEvents() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);

    }
}
