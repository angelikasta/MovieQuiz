package com.example.android.moviequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by angel on 06/02/2018.
 */

public class Quiz extends AppCompatActivity {

    public static int points = 0;
    RadioButton q1_1;
    RadioButton q1_2;
    RadioButton q1_3;

    RadioButton q2_1;
    RadioButton q2_2;
    RadioButton q2_3;

    CheckBox q3_1;
    CheckBox q3_2;
    CheckBox q3_3;
    EditText et1;
    String et1Text;

    String textMsg;
    String textError;
    Toast toast;
    Intent finalResult;
    public static final String NAME = "username";
    public static String nameuser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest1);
        Intent intent = getIntent();
        nameuser = intent.getExtras().getString(MainActivity.NAME);
        Log.v("from the quiz ", nameuser);
//        TextView textView = findViewById(R.id.textView2);
//        textView.setText(nameuser);

        q1_1 = findViewById(R.id.wrong_answer_1_1);
        q1_2 = findViewById(R.id.wrong_answer_1_2);
        q1_3 = findViewById(R.id.right_answer_1_3);

        q2_1 = findViewById(R.id.wrong_answer_2_1);
        q2_2 = findViewById(R.id.right_answer_2_2);
        q2_3 = findViewById(R.id.wrong_answer_2_3);

        q3_1 = findViewById(R.id.right_answer_3_1);
        q3_2 = findViewById(R.id.wrong_answer_3_2);
        q3_3 = findViewById(R.id.right_answer_3_3);

        et1 = findViewById(R.id.userInputEd);
    }

    public void submitAnswers(View view) {

        //check if all questions are answered
        if ((q1_1.isChecked() || q1_2.isChecked() || q1_3.isChecked())
                && (q2_1.isChecked() || q2_2.isChecked() || q2_3.isChecked())
                && (q3_1.isChecked() || q3_2.isChecked() || q3_3.isChecked())
                && !et1.getText().toString().equals("")) {

            //First question
            if (q1_3.isChecked()) {
                points += 10;}

            //Second question
            if (q2_2.isChecked()) {
                points += 10;}

            // THird question
            if (q3_1.isChecked() && q3_3.isChecked() && !q3_2.isChecked()) {
                points += 10;}

            // Check if user input is correct
            et1Text = et1.getText().toString();
            String rightAnswer = getString(R.string.correct_answer_q4);
            if (et1Text.equals(rightAnswer)) {
                points += 10;}

            textMsg = getString(R.string.quizmessage);
            toast = Toast.makeText(this, textMsg, Toast.LENGTH_LONG);
            toast.show();

            Intent intent2 = new Intent(this, FinalResults.class);
            intent2.putExtra("name", nameuser);
            Log.v("Quiz", "NAME " + NAME + " nameuser " + nameuser);


//            nameInputted = (EditText) findViewById(R.id.userName);
//            String nameTxt = nameInputted.getText().toString();


            startActivity(intent2);

//            Log.v("from the quiz ", nameuser);
//            TextView textView = findViewById(R.id.textView2);
//            textView.setText(nameuser);
//
//            finalResult = new Intent(this, FinalResults.class);
//        //    finalResult.putExtra("points", points);
//            finalResult.putExtra("userName", USERNAME);
//            startActivity(finalResult);

        } else {
            textError = getString(R.string.fill_error);
            toast = Toast.makeText(this, textError, Toast.LENGTH_LONG);
            toast.show();
        }


    }
}

