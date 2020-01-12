package com.example.android.pongmate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView paddle_one, paddle_two;
    TextView playerOneScoreText;
    TextView playerTwoScoreText;
    Switch switches;
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int goalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        playerOneScoreText = findViewById(R.id.score_player_one);
        playerTwoScoreText = findViewById(R.id.score_player_two);

        paddle_one = findViewById(R.id.paddle_img_1);
        paddle_two = findViewById(R.id.paddle_img_2);

        Random rand = new Random();
        int rand_val = rand.nextInt(2);

        if (rand_val == 0) {
            toggleImageVisibility(paddle_two);
        }
        else {
            toggleImageVisibility(paddle_one);
        }

        switches = findViewById(R.id.switch_cap);
        switches.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean is25Game) {
                if (is25Game) {
                    // The toggle is enabled
                    goalScore = 25;
                } else {
                    // The toggle is disabled
                    goalScore = 11;
                }
            }
        });
    }
  
    public void addPlayerOne(View view) {
        playerOneScore++;
        playerOneScoreText.setText(String.valueOf(playerOneScore));
        switchServe();
    }


    public void minusPlayerOne(View view) {
        if (playerOneScore > 0){
            playerOneScore--;
            playerOneScoreText.setText(String.valueOf(playerOneScore));
            switchServe();
        }
    }

    public void addPlayerTwo(View view) {
        playerTwoScore++;
        playerTwoScoreText.setText(String.valueOf(playerTwoScore));
        switchServe();
    }

    public void minusPlayerTwo(View view) {
        if (playerTwoScore > 0) {
            playerTwoScore--;
            playerTwoScoreText.setText(String.valueOf(playerTwoScore));
            switchServe();
        }
    }

    private void switchServe() {
        if((playerOneScore + playerTwoScore) % 2 == 0){
            toggleImageVisibility(paddle_one);
            toggleImageVisibility(paddle_two);
        }
    }

    private void toggleImageVisibility(ImageView paddle) {
        if (paddle.getVisibility() == View.VISIBLE) {
            paddle.setVisibility(View.GONE);
        }
        else {
            paddle.setVisibility(View.VISIBLE);
        }
    }

}
