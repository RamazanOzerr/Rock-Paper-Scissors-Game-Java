package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.rockpaperscissorsgame.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Animation anim3, anim2, anim1;
    private Random random;
    private int randomNum, computer, score;
    private List<Integer> types;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init(){
        score = 0;
        random = new Random();
        types = new ArrayList<>();

        anim1 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);

        firstRound();
        binding.constraintTop.setOnClickListener(view -> newRound());
    }

    private void newRound(){
        randomNum = generateRandomNumber();
        if(randomNum == 1){
            binding.image1.setImageResource(R.drawable.rock);
            binding.image1.setAnimation(anim3);
            types.set(0,1);
        }else if(randomNum == 2){
            binding.image1.setImageResource(R.drawable.paper);
            binding.image1.setAnimation(anim3);
            types.set(0,2);
        }else{
            binding.image1.setImageResource(R.drawable.scissors);
            binding.image1.setAnimation(anim3);
            types.set(0,3);
        }

        randomNum = generateRandomNumber();
        if(randomNum == 1){
            binding.image2.setImageResource(R.drawable.rock);
            binding.image2.setAnimation(anim3);
            types.set(1,1);
        }else if(randomNum == 2){
            binding.image2.setImageResource(R.drawable.paper);
            binding.image2.setAnimation(anim3);
            types.set(1,2);
        }else{
            binding.image2.setImageResource(R.drawable.scissors);
            binding.image2.setAnimation(anim3);
            types.set(1,3);
        }

        randomNum = generateRandomNumber();
        if(randomNum == 1){
            binding.image3.setImageResource(R.drawable.rock);
            binding.image3.setAnimation(anim3);
            types.set(2,1);
        }else if(randomNum == 2){
            binding.image3.setImageResource(R.drawable.paper);
            binding.image3.setAnimation(anim3);
            types.set(2,2);
        }else{
            binding.image3.setImageResource(R.drawable.scissors);
            binding.image3.setAnimation(anim3);
            types.set(2,3);
        }
        setOurMove();
    }

    private void computersTurn(int ourMove){
        computer = generateRandomNumber();
        if(computer == 1){
            binding.imagePlayer2.setImageResource(R.drawable.rock);
            binding.imagePlayer2.startAnimation(anim1);
            setWinner(ourMove, 1);
        } else if (computer == 2) {
            binding.imagePlayer2.setImageResource(R.drawable.paper);
            binding.imagePlayer2.startAnimation(anim1);
            setWinner(ourMove, 2);
        }else {
            binding.imagePlayer2.setImageResource(R.drawable.scissors);
            binding.imagePlayer2.startAnimation(anim1);
            setWinner(ourMove, 3);
        }
    }

    private void setWinner(int ourMove, int computersMove){
        binding.textResult.setVisibility(View.VISIBLE);
        if(ourMove == 1 && computersMove == 3){ // winner: we
            weWin();
        } else if (ourMove == 1 && computersMove == 2) { // winner: comp
            compWin();
        } else if (ourMove == 2 && computersMove == 3) { // winner: comp
            compWin();
        } else if (ourMove == 2 && computersMove == 1) { // winner: we
            weWin();
        } else if (ourMove == 3 && computersMove == 1) { // winner: comp
            compWin();
        } else if (ourMove == 3 && computersMove == 2) { // winner: we
            weWin();
        } else{  // draw
            draw();
        }

        binding.textScore.setText(String.valueOf(score));
    }

    private void weWin(){
        binding.textResult.setText("WIN");
        score += 10;
        newRound();
    }

    private void compWin(){
        binding.textResult.setText("LOST");
        score -= 10;
        newRound();
    }

    private void draw(){
        binding.textResult.setText("DRAW");
        newRound();
    }

    // helper method of newRound
    private void setOurMove(){
        binding.imagePlayer1.setVisibility(View.VISIBLE);
        binding.imagePlayer2.setVisibility(View.VISIBLE);

        binding.image1.setOnClickListener(view -> {
            if(types.get(0) == 1){
                binding.imagePlayer1.setImageResource(R.drawable.rock);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(1);
            } else if (types.get(0) == 2) {
                binding.imagePlayer1.setImageResource(R.drawable.paper);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(2);
            }else{
                binding.imagePlayer1.setImageResource(R.drawable.scissors);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(3);
            }
        });

        binding.image2.setOnClickListener(view -> {
            if(types.get(1) == 1){
                binding.imagePlayer1.setImageResource(R.drawable.rock);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(1);
            } else if (types.get(1) == 2) {
                binding.imagePlayer1.setImageResource(R.drawable.paper);
                computersTurn(2);
            }else{
                binding.imagePlayer1.setImageResource(R.drawable.scissors);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(3);
            }
        });


        binding.image3.setOnClickListener(view -> {
            if(types.get(2) == 1){
                binding.imagePlayer1.setImageResource(R.drawable.rock);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(1);
            } else if (types.get(2) == 2) {
                binding.imagePlayer1.setImageResource(R.drawable.paper);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(2);
            }else{
                binding.imagePlayer1.setImageResource(R.drawable.scissors);
                binding.imagePlayer1.startAnimation(anim2);
                computersTurn(3);
            }
        });
    }

    private void firstRound(){
        randomNum = generateRandomNumber();
        if(randomNum == 1){
            binding.image1.setImageResource(R.drawable.rock);
            binding.image1.setAnimation(anim3);
            types.add(1);
        }else if(randomNum == 2){
            binding.image1.setImageResource(R.drawable.paper);
            binding.image1.setAnimation(anim3);
            types.add(2);
        }else{
            binding.image1.setImageResource(R.drawable.scissors);
            binding.image1.setAnimation(anim3);
            types.add(3);
        }

        randomNum = generateRandomNumber();
        if(randomNum == 1){
            binding.image2.setImageResource(R.drawable.rock);
            binding.image2.setAnimation(anim3);
            types.add(1);
        }else if(randomNum == 2){
            binding.image2.setImageResource(R.drawable.paper);
            binding.image2.setAnimation(anim3);
            types.add(2);
        }else{
            binding.image2.setImageResource(R.drawable.scissors);
            binding.image2.setAnimation(anim3);
            types.add(3);
        }

        randomNum = generateRandomNumber();
        if(randomNum == 1){
            binding.image3.setImageResource(R.drawable.rock);
            binding.image3.setAnimation(anim3);
            types.add(1);
        }else if(randomNum == 2){
            binding.image3.setImageResource(R.drawable.paper);
            binding.image3.setAnimation(anim3);
            types.add(2);
        }else{
            binding.image3.setImageResource(R.drawable.scissors);
            binding.image3.setAnimation(anim3);
            types.add(3);
        }

        binding.textScore.setText("0");
        setOurMove();
    }

    // generates a random number 1-3, we used to get a new card
    private int generateRandomNumber() {
        return random.nextInt(3) + 1;
    }

}