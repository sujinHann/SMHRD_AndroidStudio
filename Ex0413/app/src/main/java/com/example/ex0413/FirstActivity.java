package com.example.ex0413;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity {

    //전역 변수 설정
    Button btnFirst, btnFirst2, btnCapture;
    EditText edtData;

    //액티비티 결과 수신에 대한 기능 구현
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // 화면 전환했던 액티비티로부터 데이터를 받아온 후 실행할 로직 구현
                    // 데이터를 result 객체로부터 꺼내올 수 있음

                    //result.getResultCode() : 결과코드를 반환하는 메소드(RESULT_OK or RESULT_CANCELED)
                    //result.getData() : Intent에 저장된 데이터를 반환하는 메소드
                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();

                        Log.d("FirstActivity", intent.getStringExtra("msg"));
                    }

                }
            }

    );

    ActivityResultLauncher<Intent> launcher_capture = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK){
                        Bundle bundle = result.getData().getExtras();
                        
                        //사진을 찍었을 때 안드로이드 내부에 Bundle 공간에 저장
                        //"data"라는 이름으로 Bitmap 타입의 사진데이터가 저장됨
                        //get()는 Object로 반환해주기 때문에 Bitmap타입으로 다운캐스팅
                        
                        Bitmap bitmap = (Bitmap) bundle.get("data");
                        ImageView img = findViewById(R.id.imageView);
                        img.setImageBitmap(bitmap);


                    }

                }
            }


    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //초기화
        btnFirst = findViewById(R.id.btnFirst);
        btnFirst2 = findViewById(R.id.btnFirst2);
        btnCapture = findViewById(R.id.btnCapture);
        edtData = findViewById(R.id.edtData);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getText 형이 editTable => 형변환 필요 => toString
                String data =  edtData.getText().toString();

                //secondActivity로 이동하는 기능 구현
                //Intent(현재 액티비티명.this, 화면 전환할 액티비티명.class)
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

                //Intent 객체에 전달할 데이터를 저장
                intent.putExtra("data",data);
                intent.putExtra("num",10);

                // Intent 객체를 실행 시키는 메소드
                startActivity(intent);

                // 현재 액티비티를 종료하는 메소드
                finish();
            }
        });

        btnFirst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);

                //ThirdActivity를 실행한 후 결과에 대한 처리는
                //onActivityResult()에서 처리할 수 있도록 실행하는 메소드
                launcher.launch(intent);



            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher_capture.launch(intent);

            }
        });
    }
}