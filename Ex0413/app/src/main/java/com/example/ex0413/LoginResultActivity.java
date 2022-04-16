package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    TextView tvtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        //초기화
        tvtext = findViewById(R.id.tvtext);

        //Intent 객체생성
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String pw = intent.getStringExtra("pw");

        if(email.equals("seunghyun@babo.com")&&pw.equals("666")){
            tvtext.setText("박승현은 바보입니다!");
        }else{
            tvtext.setText("홍성채와 박승현은 닮았습니다!");
        }


    }
}