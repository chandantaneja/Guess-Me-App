package com.chandantanejadev.guessmeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    EditText edNum;
    Button btnGuess;
    private static final String TAG = "MainActivity";
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Random random = new Random();
        randomNumber = random.nextInt(100)+1;
        edNum = findViewById(R.id.editNum);
        btnGuess = findViewById(R.id.btn_guess);
        context = this;

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(edNum.getText().toString()) > 100 || Integer.parseInt(edNum.getText().toString()) < 0 ){
                    Toast.makeText(context, "Are you an Idiot?", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(edNum.getText().toString()) <= 100 && Integer.parseInt(edNum.getText().toString()) > 0){
                   if (Integer.parseInt(edNum.getText().toString()) > randomNumber) {
                       Toast.makeText(context, edNum.getText().toString() + ". You are flying too high", Toast.LENGTH_SHORT).show();
                   }
                   else if (Integer.parseInt(edNum.getText().toString()) < randomNumber){
                       Toast.makeText(context, edNum.getText().toString() + ". Please think Bigger", Toast.LENGTH_SHORT).show();
                   }
                   else if (Integer.parseInt(edNum.getText().toString()) == randomNumber){
                       Toast.makeText(context, "OMG! You are SMART... wanna play again? ", Toast.LENGTH_SHORT).show();
                       randomNumber = random.nextInt(100)+1;
                   }
                }
                edNum.setText("");
            }
        });

    }
}
