package com.example.raiff.latequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button quizSubmitButton;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizSubmitButton = (Button) findViewById(R.id.quizSubmitButton);
        quizSubmitButton.setOnClickListener(quizSubmitButtonListener);


    }

    private void questionOne() {
        RadioButton radioFour = (RadioButton) findViewById(R.id.radio_question1_answer2);
        boolean isCorrectAnswer = radioFour.isChecked();
        if (isCorrectAnswer) {
            score += 1;
        }
    }

    private void questionTwo() {
        RadioButton radioFour = (RadioButton) findViewById(R.id.radio_question2_answer1);
        if (radioFour.isChecked()) {
            score += 1;
        }
    }

    private void questionThree() {
        CheckBox boxOneAnswer = findViewById(R.id.checkBox_question3_answer1);
        CheckBox boxTwoAnswer = findViewById(R.id.checkBox_question3_answer2);
        CheckBox boxThreeAnswer = findViewById(R.id.checkBox_question3_answer3);
        if (boxOneAnswer.isChecked() && !boxTwoAnswer.isChecked() && boxOneAnswer.isChecked()) {
            score += 1;
        }
    }

    private void questionFour() {
        EditText inputAnswer = findViewById(R.id.question4_answer);
        String convertedAnswer = inputAnswer.getText().toString();
        if (convertedAnswer.trim().equalsIgnoreCase("starkiller")){
            score += 1;
        }
    }

    private void getResults() {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();

    }
    final View.OnClickListener quizSubmitButtonListener = new View.OnClickListener() {
        public void onClick(final View view) {
            getResults();
            Toast.makeText(MainActivity.this, "Results:" + score, Toast.LENGTH_LONG).show();
            score = 0;
        }
    };
}
