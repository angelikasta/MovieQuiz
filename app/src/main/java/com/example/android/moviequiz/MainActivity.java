package com.example.android.moviequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NAME = "NAME";
    EditText nameInputted;
    String textMsg;
    Toast toast1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nameInputted = findViewById(R.id.userName);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, Quiz.class);
        nameInputted = (EditText) findViewById(R.id.userName);
        String nameTxt = nameInputted.getText().toString();
        if (nameTxt.equals("")) {
            textMsg = getString(R.string.username_error);
            toast1 = Toast.makeText(this, textMsg, Toast.LENGTH_LONG);
            toast1.show();
        } else {
            intent.putExtra(NAME, nameTxt);
            Log.v("MainActivity", "from main nameTxt: " + nameTxt + " NAME: " + NAME);
            startActivity(intent);

        }
    }
}

