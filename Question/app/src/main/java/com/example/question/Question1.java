package com.example.question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Question1 extends AppCompatActivity {

    Button btnChange1, btnChange2, btnChange3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        btnChange1 = findViewById(R.id.btnFirst);
        btnChange2 = findViewById(R.id.btnSecond);
        btnChange3 = findViewById(R.id.btnThird);

        btnChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChange1.setText(R.string.btn_ch1);
            }
        });

        btnChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChange2.setText(R.string.btn_ch2);
            }
        });

        btnChange3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChange3.setText(R.string.btn_ch3);
            }
        });

    }



    }
