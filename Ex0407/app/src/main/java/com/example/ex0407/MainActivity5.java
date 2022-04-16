package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    ImageView img1, img2;
    Button btn_shake;
    TextView game;

    int i=0;
    int j=0;

    // 이미지 배열 생성
    int[] imgArr = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                    R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        btn_shake = findViewById(R.id.btn_shake);
        game = findViewById(R.id.game);

        btn_shake.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int imageId1 = (int)(Math.random() * imgArr.length);
                int imageId2 = (int)(Math.random() * imgArr.length);

                img1.setImageResource(imgArr[imageId1]);
                img2.setImageResource(imgArr[imageId2]);


                if(imageId1  == imageId2){
                    Toast.makeText(MainActivity5.this,
                                    "무승부",
                                    Toast.LENGTH_SHORT).show();

                } else if (imageId1 > imageId2) {
                    i++;
                } else {
                    j++;
                }

                game.setText(i+":"+j);

            }
        });
    }
}