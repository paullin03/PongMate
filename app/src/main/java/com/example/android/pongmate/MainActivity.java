package com.example.android.pongmate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            View view = getWindow().getDecorView();
                            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
                            view.setSystemUiVisibility(uiOptions);
                        }
                    }
                });
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
