package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz_Activity extends AppCompatActivity {
    private Button mButton_aboutRules, mButton_startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_);

        mButton_aboutRules = (Button)findViewById(R.id.button_aboutRules);
        mButton_aboutRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rulesIntent = new Intent(Quiz_Activity.this, RulesActivity.class);
                startActivity(rulesIntent);
            }
        });

        mButton_startGame = (Button)findViewById(R.id.button_start);
        mButton_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGameIntent = new Intent(Quiz_Activity.this, StartQuizActivity.class);
                startActivity(startGameIntent);
            }
        });
    }
}