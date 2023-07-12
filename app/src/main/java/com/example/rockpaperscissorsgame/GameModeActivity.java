package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.rockpaperscissorsgame.databinding.ActivityGameModeBinding;

public class GameModeActivity extends AppCompatActivity {

    private ActivityGameModeBinding binding;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameModeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getHighestScore();
        setButtonListeners();

    }

    private void getHighestScore() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                String.valueOf(R.string.shared_preferences_key), Context.MODE_PRIVATE);
        highScore = sharedPreferences.getInt(getString(R.string.saved_high_score_key), 0);
        binding.textHighestScore.setText(String.valueOf(highScore));
    }

    private void setButtonListeners() {
        binding.buttonEasy.setOnClickListener(view -> startGame("easy"));
        binding.buttonMed.setOnClickListener(view -> startGame("med"));
        binding.buttonHard.setOnClickListener(view -> startGame("hard"));
    }


    private void startGame(String gameMode){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("gamemode", gameMode);
        intent.putExtra("highest_score", highScore);
        startActivity(intent);
    }
}