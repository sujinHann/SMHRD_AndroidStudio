package com.example.ex0425;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserId, edtUserPw;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserId = findViewById(R.id.edtUserId);
        edtUserPw = findViewById(R.id.edtUserPw);
        btnLogin = findViewById(R.id.btnLogin);

        //버튼 클릭시 ChatActivity로 화면전환(Intent활용)
        //입력한 id/pw 비교후  id를 전달하기

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = edtUserId.getText().toString();
                String pw = edtUserPw.getText().toString();

                if(id.equals("sj") && pw.equals("1234")){

                    Intent intent = new Intent(LoginActivity.this,
                            ChatActivity.class);
                    intent.putExtra("login_id",id);

                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity.this,
                            "다시로그인해주세요",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}