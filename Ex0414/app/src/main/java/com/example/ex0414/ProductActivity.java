package com.example.ex0414;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {


    ListView lv_product;
    ProductAdapter adapter;
    ArrayList<ProductVO> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        lv_product = findViewById(R.id.lv_product);
        list = new ArrayList<>();

        //리소스ID를 동적으로 접근나는 방법
        for(int i=0; i<11; i++){
            //리소스객체접근, 리소스ID반환메소드(리소드ID,리소드타입, 패키지명)
            int imgId= getResources().getIdentifier("item"+(i+1), "drawable",getPackageName());
            int strId= getResources().getIdentifier("item"+(i+1), "string",getPackageName());

            list.add(new ProductVO(imgId,strId, "10"));
        }

        adapter = new ProductAdapter(ProductActivity.this,
                R.layout.product_item,
                list);



        lv_product.setAdapter(adapter);


    }



}
