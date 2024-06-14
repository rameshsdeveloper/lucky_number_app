package com.example.lucky_number_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button buttonLuck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonLuck = findViewById(R.id.buttonLuck);

        buttonLuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString();

                if (!username.isEmpty()) {
                    int randomNumber = generateLuckyNumber();

                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                    intent.putExtra("username", username);
                    intent.putExtra("randomNumber", randomNumber);

                    startActivity(intent);
                }
            }
        });
    }

    private int generateLuckyNumber() {
        Random random = new Random();
        return random.nextInt(900) + 100;
    }
}