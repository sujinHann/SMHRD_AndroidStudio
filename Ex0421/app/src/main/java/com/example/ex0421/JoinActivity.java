package com.example.ex0421;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {

    EditText edtRegisterId, edtRegisterNick, edtRegisterPw;
    Button btnRegister;

    RequestQueue queue;
    StringRequest request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edtRegisterId = findViewById(R.id.edtRegisterId);
        edtRegisterNick = findViewById(R.id.edtRegisterNick);
        edtRegisterPw = findViewById(R.id.edtRegisterPw);
        btnRegister = findViewById(R.id.btnRegister);

        queue = Volley.newRequestQueue(JoinActivity.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int method = Request.Method.POST;
                String server_url = "http://59.0.234.149:8081/android/Join";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(JoinActivity.this,
                                        "요청성공",
                                        Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(JoinActivity.this, "요청실패!>>"+error.toString(),
                                        Toast.LENGTH_SHORT).show();

                            }
                        }


                ){
                    //POST방식으로 데이터를 전송할 때 사용하는 메소드
                    //요청을 보냈을때 같이 설정해주는 메서드 getParams()

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        //여기서 저장한 데이터를 헤더라는 영역에 담아 전달해주는 역할 > Map타입
                        Map<String,String> param = new HashMap<>();
                        param.put("id", edtRegisterId.getText().toString());
                        param.put("pw", edtRegisterPw.getText().toString());
                        param.put("nick", edtRegisterNick.getText().toString());


                        return param;
                        //key와 value형태로 데이터를 저장하는 자료 구조 --> map
                    }
                }; //end

                queue.add(request);
            }
        });



    }
}