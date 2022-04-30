package com.example.ex0425;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ChatActivity extends AppCompatActivity {

    ListView Chatlist;
    ChatAdapter adapter;
    EditText edtMsg;
    Button btnMsgSend;
    ArrayList<ChatVO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Chatlist = findViewById(R.id.Chatlist);
        edtMsg = findViewById(R.id.edtMsg);
        btnMsgSend = findViewById(R.id.btnMsgSend);
        list = new ArrayList<>();

        String currentId = getIntent().getStringExtra("login_id");
        Log.d("ChatActivity", "현재 로그인한 아이디:" + currentId);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("talk");

        //1.버튼 클릭 시 입력된 메시지를 파이어베이스 데이버베이스에 저장
        btnMsgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //현재시간 구하기(스마트폰시간)
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                String time = sdf.format(cal.getTime());

                String msg = edtMsg.getText().toString();

                myRef.push().setValue(new ChatVO(
                        R.drawable.ic_launcher_background,
                        currentId,
                        msg,
                        time
                        ));

            }
        });

        //2. 파이어베이스 데이터베이스에 저장된 데이터를 가져온 후 list객체에 저장
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //읽어올때는 자료형 맞춰서
                ChatVO vo = snapshot.getValue(ChatVO.class);
                //객체를 어디에 저장할까요? list!
                list.add(vo);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        adapter = new ChatAdapter(ChatActivity.this,
                R.layout.chat_item,
                list,
                currentId);

        Chatlist.setAdapter(adapter);
    }
}