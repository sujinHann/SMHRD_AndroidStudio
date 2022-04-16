package com.example.ex0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;
    EditText edtData;
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        edtData = findViewById(R.id.edtData);
        lv = findViewById(R.id.lv);
        list = new ArrayList<String>();

        list.add("피자");
        list.add("푸틴");
        list.add("연어");
        list.add("치킨");
        list.add("아메리카노");
        list.add("비빔국수");
        list.add("마라샹궈");
        list.add("짬뽕");
        list.add("삼겹살");
        list.add("수육");
        list.add("양갈비");
        list.add("짜파구리");
        list.add("너구리볶음면");
        list.add("바닐라크림콜드브루");

        //new ArrayAdapter(현재 액티비티명.this, 레이아웃, 데이터);
        // 레이아웃: 리스트뷰에 보여질 아이템뷰를 가르킴
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                list
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView: 클릭이 일어난 AdapterView
                //view: 클릭한 아이템뷰를 View 객체로 반환
                //i, l: 클릭한 아이템뷰의 행 인덱스를 반환

                //매개변수가 많네?!
                String data =list.get(i);
                Toast.makeText(MainActivity.this, "선택한 항복: "+data, Toast.LENGTH_SHORT).show();
            }
        });

        //롱클릭 시 아이템 삭제하는 기능구현
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"롱클릭!",Toast.LENGTH_LONG);

                String IoT101 = list.get(i);
                adapter.remove(IoT101);

                return false;
            }
        });

        //버튼을 클릭했을 때 listView에 데이터 저장
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String IoT101 =  edtData.getText().toString();
                //list.add(fruit);
                adapter.add(IoT101);

                // 어댑터에 데이터를 추가한 후 listView를 업데이트하는 메소드
                //adapter.notifyDataSetChanged();
            }
        });

    }
}