package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.rockpaperscissorsgame.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private Animation anim1;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_splash);

        anim1 = AnimationUtils.loadAnimation(this, R.anim.anim3);
        AppCompatImageView imageView = findViewById(R.id.imageViewSplash);
        imageView.setAnimation(anim1);

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_splash_root);
        constraintLayout.setOnClickListener(view ->
                startActivity(new Intent(this, MainActivity.class)));

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        },1800);


    }
}