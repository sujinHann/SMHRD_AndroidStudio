package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Button plu, min, mul, div;
    TextView result;
    EditText num1, num2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //View를 초기화하는 메소드
        initView();


        plu.setOnClickListener(this);
        min.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);

    }

    private void initView() {
        plu = findViewById(R.id.plu);
        min = findViewById(R.id.min);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
    }

    @Override
    public void onClick(View view) {

        int view_id = view.getId();

        double edit1 = Double.parseDouble(num1.getText().toString());
        double edit2 = Double.parseDouble(num2.getText().toString());

        double total = 0;

//        String edit1 = num1.getText().toString();
//        String edit2 = num2.getText().toString();
//
//        int n1 = Integer.parseInt(edit1);
//        int n2 = Integer.parseInt(edit2);

        if (view_id == R.id.plu) {
            total = edit1+edit2;
        } else if(view_id == R.id.min){
            total = edit1-edit2;
        } else if(view_id == R.id.mul){
            total = edit1*edit2;
        } else {
            total = edit1/edit2;
        }

        result.setText("연산결과 : " + String.valueOf(total));

        //result.setText("계산결과 : " + total);

    }
}