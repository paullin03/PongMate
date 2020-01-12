package com.example.android.pongmate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ImageView paddle_one, paddle_two;
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
    }
  
    public void addPlayerOne(View view) {
        int val = Integer.parseInt(playerOneScore.getText().toString());
        System.out.println(val);
        playerOneScore.setText(String.valueOf(val + 1));
    }
  
    public void minusPlayerOne(View view) {
        int val = Integer.parseInt(playerOneScore.getText().toString());
        System.out.println(val);
        playerOneScore.setText(String.valueOf(val - 1));
    }

    public void addPlayerTwo(View view) {
        int val = Integer.parseInt(playerTwoScore.getText().toString());
        System.out.println(val);
        playerTwoScore.setText(String.valueOf(val + 1));
    }

    public void minusPlayerTwo(View view) {
        int val = Integer.parseInt(playerTwoScore.getText().toString());
        System.out.println(val);
        playerTwoScore.setText(String.valueOf(val - 1));
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
