package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.anim3);
        AppCompatImageView imageView = findViewById(R.id.imageViewSplash);
        imageView.setAnimation(anim1);

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_splash_root);
        constraintLayout.setOnClickListener(view -> {
            startActivity(new Intent(this, GameModeActivity.class));
            finish();
        });

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, GameModeActivity.class));
            finish();
        },1800);

    }
}