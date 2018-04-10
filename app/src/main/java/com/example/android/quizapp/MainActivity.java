package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    final int Q1RightChoice = R.id.Q1_A3;
    final int Q2RightChoice = R.id.Q2_A1;
    final String Q4RightChoice = "FCA";
    final int Q5RightChoice = R.id.Q5_A3;
    final String Q6RightChoice = "Less Truck Load";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View v) {
        ArrayList<String> falseAnswersList = new ArrayList<>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            falseAnswersList.add("Question 1");
        }

        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            falseAnswersList.add("Question 2");
        }

        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            falseAnswersList.add("Question 3");
        }

        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            falseAnswersList.add("Question 4");
        }

        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            falseAnswersList.add("Question 5");
        }

        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            falseAnswersList.add("Question 6");
        }


        StringBuilder sb = new StringBuilder();
        for (String s : falseAnswersList) {
            sb.append(s);
        }

        Context applicationContext = getApplicationContext();
        CharSequence text = "You have " + numberOfQuestionsCorrect + "/right answers out of 6 questions.\n\n Check again the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(applicationContext, text, duration);
        toast.show();
    }

    private boolean checkQuestion1() {
        RadioGroup rg = findViewById(R.id.Q1_radio_buttons);

        return rg.getCheckedRadioButtonId() == Q1RightChoice;

    }

    private boolean checkQuestion2() {
        RadioGroup rg = findViewById(R.id.Q2_radio_buttons);

        return rg.getCheckedRadioButtonId() == Q2RightChoice;

    }

    private boolean checkQuestion3() {
        CheckBox option1 = findViewById(R.id.Q3_A1);
        CheckBox option2 = findViewById(R.id.Q3_A2);
        CheckBox option3 = findViewById(R.id.Q3_A3);

        return option1.isChecked() && option2.isChecked() && option3.isChecked();
    }

    private boolean checkQuestion4() {
        EditText et = findViewById(R.id.Q4EditText);

        return et.getText().toString().equalsIgnoreCase(Q4RightChoice);
    }

    private boolean checkQuestion5() {
        RadioGroup rg = findViewById(R.id.Q5_radio_buttons);

        return rg.getCheckedRadioButtonId() == Q5RightChoice;

    }

    private boolean checkQuestion6() {
        EditText et = findViewById(R.id.Q6EditText);

        return et.getText().toString().equalsIgnoreCase(Q6RightChoice);
    }
}