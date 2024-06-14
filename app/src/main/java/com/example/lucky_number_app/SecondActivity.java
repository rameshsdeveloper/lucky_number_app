package com.example.lucky_number_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView luckyTextView, luckyNumberTextView;
    Button buttonSharing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        luckyTextView = findViewById(R.id.luckyTextView);
        luckyNumberTextView = findViewById(R.id.luckyNumberTextView);
        buttonSharing = findViewById(R.id.button_sharing);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int randomNumber = intent.getIntExtra("randomNumber", 100);

        luckyTextView.setText(username + " Lucky Number is:");
        luckyNumberTextView.setText(randomNumber + "");

        buttonSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLuckyNumber(username, randomNumber);
            }
        });

    }

    private void shareLuckyNumber(String username, int randomNumber) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, username + " Lucky number is: " + randomNumber);
        startActivity(Intent.createChooser(intent, "Assignment 1"));
    }
}