package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    int mCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //counterView is the TextView that displays the value of the counter
        TextView counterView = findViewById(R.id.counterId);
        Button reset_btn = findViewById(R.id.buttonResetId);
        Button increment_btn = findViewById(R.id.buttonIncId);
        Button decrement_btn = findViewById(R.id.buttonDecId);
        Button tost_btn = findViewById(R.id.buttonToastId);
        Button snackbar_btn = findViewById(R.id.buttonSnackbarId);

        //TODO
        // Your code goes here

        reset_btn.setOnClickListener(v -> {
            mCounter = 0;
            counterView.setText(String.valueOf(mCounter));
        });

        increment_btn.setOnClickListener(v -> {
            mCounter = mCounter +1;
            counterView.setText(String.valueOf(mCounter));
        });

        decrement_btn.setOnClickListener(v -> {
            mCounter = mCounter -1;
            counterView.setText(String.valueOf(mCounter));
        });

        tost_btn.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,"Counter Value is "+mCounter,Toast.LENGTH_LONG).show();
        });


        snackbar_btn.setOnClickListener(v-> {
            Snackbar.make(v,"Counter Value is "+mCounter,Snackbar.LENGTH_LONG).show();
        });
    }
}