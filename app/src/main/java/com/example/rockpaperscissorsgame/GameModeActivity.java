package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.rockpaperscissorsgame.databinding.ActivityGameModeBinding;

public class GameModeActivity extends AppCompatActivity {

    private ActivityGameModeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameModeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setButtonListeners();

    }

    private void setButtonListeners() {
        binding.buttonEasy.setOnClickListener(view -> startGame("easy"));
        binding.buttonMed.setOnClickListener(view -> startGame("med"));
        binding.buttonHard.setOnClickListener(view -> startGame("hard"));
    }


    private void startGame(String gameMode){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("gamemode", gameMode);
        startActivity(intent);
    }
}