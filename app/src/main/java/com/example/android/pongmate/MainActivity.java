package com.example.android.pongmate;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView paddleOne, paddleTwo;

    TextView playerOneScore;

    TextView playerTwoScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        playerOneScore = findViewById(R.id.score_player_one);
        playerTwoScore = findViewById(R.id.score_player_two);

        paddleOne = findViewById(R.id.paddle_img_1);
        paddleTwo = findViewById(R.id.paddle_img_2);

        setServer();
    }

    public void addPlayerOne(View view) {
        int val = Integer.parseInt(playerOneScore.getText().toString());
        playerOneScore.setText(String.valueOf(val + 1));
        switchServe();
    }

    public void minusPlayerOne(View view) {
        int val = Integer.parseInt(playerOneScore.getText().toString());
        if (val > 0) {
            playerOneScore.setText(String.valueOf(val - 1));
            switchServe();
        }
    }

    public void addPlayerTwo(View view) {
        int val = Integer.parseInt(playerTwoScore.getText().toString());
        playerTwoScore.setText(String.valueOf(val + 1));
        switchServe();
    }

    public void minusPlayerTwo(View view) {
        int val = Integer.parseInt(playerTwoScore.getText().toString());
        if (val > 0) {
            playerTwoScore.setText(String.valueOf(val - 1));
            switchServe();
        }
    }

    public void resetScore(View view) {
        playerOneScore.setText("0");
        playerTwoScore.setText("0");
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
        int playerOne = Integer.parseInt(playerOneScore.getText().toString());
        int playerTwo = Integer.parseInt(playerTwoScore.getText().toString());
        if ((playerOne + playerTwo) % 2 == 0) {
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
