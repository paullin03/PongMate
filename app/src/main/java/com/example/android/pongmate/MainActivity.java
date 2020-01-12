package com.example.android.pongmate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView playerOneScore;
    TextView playerTwoScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneScore = findViewById(R.id.score_player_one);
        playerTwoScore = findViewById(R.id.score_player_two);
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

}
