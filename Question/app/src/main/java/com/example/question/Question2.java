package com.example.question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Question2 extends AppCompatActivity {

    ImageView img;
    Button btnPre, btnNext;

    int i = 0;

    // 이미지 배열 생성
    int[] imgArr = {R.drawable.sh1, R.drawable.sh2, R.drawable.sh3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        img = findViewById(R.id.img);
        btnPre = findViewById(R.id.btnPre);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(i == imgArr.length-1){
                    i = 0;
                } else {
                    i++;
                }
                img.setImageResource(imgArr[i]);
            }
        }); // Next_end

        btnPre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(i == 0){
                    i = imgArr.length-1;
                } else {
                    i--;
                }
                img.setImageResource(imgArr[i]);
            }
        }); // Pre_end


    }
}