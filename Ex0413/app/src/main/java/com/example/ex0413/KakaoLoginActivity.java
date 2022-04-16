package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KakaoLoginActivity extends AppCompatActivity {

    //전역 변수 설정
    Button btn_login;
    EditText edt_email, edt_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login);

        //초기화
        btn_login = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_email);
        edt_pw = findViewById(R.id.edt_pw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent(현재 액티비티명.this, 화면 전환할 액티비티명.class)
                //첫번째
                Intent intent = new Intent(KakaoLoginActivity.this, LoginResultActivity.class);

                //Intent 객체에 전달할 데이터를 저장
                intent.putExtra("email",edt_email.getText().toString());
                intent.putExtra("pw",edt_pw.getText().toString());

                // Intent 객체를 실행 시키는 메소드
                startActivity(intent);

            }
        });
    }
}