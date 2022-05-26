package com.example.ex0430;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment3 extends Fragment {

    EditText edtUrl;
    Button btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_3, container, false);

        edtUrl = view.findViewById(R.id.edtUrl);
        btnSave = view.findViewById(R.id.btnSave);

        //SharedPreferences
        // : 앱의 데이터를 저장하기 위한 객체
        // : 간단한 데이터를 Key, Value 형태로 저장 -> 안드로이드 내부에 XML 파일로 저장
        //Context.MODE_PRIVATE
        // : 외부 앱에서 접근 불가하도록 설정
        SharedPreferences spf = getActivity()
                .getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = spf.edit();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 사용자가 URL값을 입력하면 저장
                String url = edtUrl.getText().toString();

                //URL 값을 mySPF.xml 파일에 url값을 저장
                editor.putString("url",url);
                editor.commit();

                //getActivity() --> MainActivity
                Toast.makeText(getActivity(), "새로운 주소가 설정되었습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}