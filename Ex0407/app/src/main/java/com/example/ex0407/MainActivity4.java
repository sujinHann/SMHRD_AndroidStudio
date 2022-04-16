package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    ImageView img;
    Button btnPre, btnNext;

    int i = 0;

    // 이미지 배열 생성
    int[] imgArr = {R.drawable.sh1, R.drawable.sh2, R.drawable.sh3, R.drawable.sh4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
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


//        btnPre.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                    if(i<0){
//                        i = 3;
//                    } else if(i<=3){
//                        img.setImageResource(imgArr[i]);
//                        i++;
//                    }
//            }
//        });
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                if(i<4){
//                    img.setImageResource(imgArr[i]);
//                    i++;
//                } else if(i>=4){
//                    i = 0;
//                    img.setImageResource(imgArr[i]);
//                }
//
//
//            }
//        });




    }
}