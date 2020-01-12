package com.example.android.pongmate;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  
    private ImageView paddleOne, paddleTwo;

    TextView playerOneScoreText;

    TextView playerTwoScoreText;
  
    Switch switches;
  
    int playerOneScore = 0;
  
    int playerTwoScore = 0;
  
    int goalScore = 11;

    int switchServiceAmount = 2;

    boolean isDeuce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        playerOneScoreText = findViewById(R.id.score_player_one);
        playerTwoScoreText = findViewById(R.id.score_player_two);

        paddleOne = findViewById(R.id.paddle_img_1);
        paddleTwo = findViewById(R.id.paddle_img_2);
        switches = findViewById(R.id.switch_cap);
      
        switches.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean is25Game) {
                if (is25Game) {
                    // The toggle is enabled
                    goalScore = 21;
                    switchServiceAmount = 5;
                } else {
                    // The toggle is disabled
                    goalScore = 11;
                    switchServiceAmount = 2;
                }
            }
        });
        setServer();
    }

    public void addPlayerOne(View view) {
        changeScore(1,1);
    }

    public void minusPlayerOne(View view) {
        if (playerOneScore > 0){
            changeScore(1,-1);
        }
    }

    public void addPlayerTwo(View view) {
        changeScore(2,1);
    }

    public void minusPlayerTwo(View view) {
        if (playerTwoScore > 0) {
            changeScore(2,-1);
        }
    }

    public void changeScore(int player, int change){
        if (player == 1) {
            playerOneScore = playerOneScore + change;
            playerOneScoreText.setText(String.valueOf(playerOneScore));
        } else {
            playerTwoScore = playerTwoScore + change;
            playerTwoScoreText.setText(String.valueOf(playerTwoScore));
        }

        if (isDeuce) {
            if (Math.abs(playerOneScore - playerTwoScore) > 1){
                reset();
            }
        }
        else if (playerOneScore == goalScore || playerTwoScore == goalScore) {
            reset();
        }

        if (playerOneScore == goalScore - 1 && playerTwoScore == goalScore - 1){
            isDeuce = true;
        }

        switchServe();
    }

    public void resetScore(View view) {
        reset();
    }

    private void reset(){
        playerOneScore = 0;
        playerTwoScore = 0;
        playerOneScoreText.setText("0");
        playerTwoScoreText.setText("0");
        isDeuce = false;
        setServer();
    }

    private void setServer() {
        setNoServer();
        int rand_val = new Random().nextInt(2);

        if (rand_val == 0) {
            toggleImageVisibility(paddleTwo);
        } else {
            toggleImageVisibility(paddleOne);
        }
    }

    private void switchServe() {
        if(isDeuce || (playerOneScore + playerTwoScore) % switchServiceAmount == 0){
            toggleImageVisibility(paddleOne);
            toggleImageVisibility(paddleTwo);
        }
    }

    private void toggleImageVisibility(ImageView paddle) {
        if (paddle.getVisibility() == View.VISIBLE) {
            paddle.setVisibility(View.GONE);
        } else {
            paddle.setVisibility(View.VISIBLE);
        }
    }

    private void setNoServer() {
        paddleOne.setVisibility(View.GONE);
        paddleTwo.setVisibility(View.GONE);
    }

}
