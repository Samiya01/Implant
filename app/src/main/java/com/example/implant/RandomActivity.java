package com.example.implant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        final Random myRandom = new Random();


        Button buttonGenerate = (Button)findViewById(R.id.generate);
        final TextView textGenerateNumber1 = (TextView)findViewById(R.id.generatenumber1);
        final TextView textGenerateNumber2 = (TextView)findViewById(R.id.generatenumber2);
        final TextView textGenerateNumber3 = (TextView)findViewById(R.id.generatenumber3);
        final TextView textGenerateNumber4 = (TextView)findViewById(R.id.generatenumber4);
        final TextView textGenerateNumber5 = (TextView)findViewById(R.id.generatenumber5);
        final TextView textGenerateNumber6 = (TextView)findViewById(R.id.generatenumber6);

        buttonGenerate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                textGenerateNumber1.setText(String.valueOf(myRandom.nextInt(100)));
                textGenerateNumber2.setText(String.valueOf(myRandom.nextInt(100)));
                textGenerateNumber3.setText(String.valueOf(myRandom.nextInt(100)));
                textGenerateNumber4.setText(String.valueOf(myRandom.nextInt(100)));
                textGenerateNumber5.setText(String.valueOf(myRandom.nextInt(100)));
                textGenerateNumber6.setText(String.valueOf(myRandom.nextInt(100)));
            }
        });
    }
}