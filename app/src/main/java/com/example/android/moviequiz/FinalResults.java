package com.example.android.moviequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by angel on 06/02/2018.
 */

public class FinalResults extends AppCompatActivity{
    int finalPoints;
    int percent;
    TextView resultPercentage;
    TextView testView;
    String testing;
    String userName;
    Intent mailIntent;
    String mailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        Intent intent = getIntent();
        String message = intent.getExtras().getString(Quiz.nameuser);
        Log.v("from the final page ", message);
        TextView testView = findViewById(R.id.testView);
        testView.setText(message);
      //  finalPoints = getIntent().getExtras().getInt("points");

    //    percent = (finalPoints * 100) / 5;
//        resultPercentage = (TextView) findViewById(R.id.result_percentage);
  //      resultPercentage.setText(percent + getString(R.string.percent));
      //  userName = getIntent().getExtras().getString("userName");


    }
}
