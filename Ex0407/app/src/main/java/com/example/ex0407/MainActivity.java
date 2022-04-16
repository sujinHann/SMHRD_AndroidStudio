package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button plus, minus;
    TextView num;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        num.setText(cnt + "");

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int view_id = view.getId();

        //TextView 값을 연산하기 위해서 정수로 변환
        String up = num.getText().toString();
        int n = Integer.parseInt(up);

        if (view_id == R.id.plus) {
            cnt = cnt + 1;
            //num.setText(cnt + "");
            //setText()에 값을 넣을 경우 반드시 문자열만 가능
            num.setText(String.valueOf(n));
        } else {
                if(n>0){
                    n -=1;
            } else{
                    num.setText(String.valueOf(n));
                }


//            if (cnt <= 0) {
//                cnt = 0;
//            } else {
//                cnt = cnt - 1;
//                num.setText(cnt + "");
            }
        }

    }


