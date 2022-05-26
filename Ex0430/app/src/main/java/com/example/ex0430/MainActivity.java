package com.example.ex0430;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
//1. 눌렀을 때, 화면이 전환되는 구조


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Fragment1 frag_home;
    Fragment2 frag_time;
    Fragment3 frag_option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav=findViewById(R.id.bottmNav);
        //2.객체 선언
        frag_home = new Fragment1();
        frag_time = new Fragment2();
        frag_option = new Fragment3();

        //3.실행 시 처음에 보여줄 프래그먼트 화면 설정
        //버튼 눌렀을 때, 전환하는 용도로도 활용 가능
        //메소드 호출시,객체 반환 commit실행 메소드
        //replace(프래그먼트를 보여주는 레이아웃 리소스 ID ,보여줄 프래그먼트 객체)
        getSupportFragmentManager().beginTransaction().replace(R.id.container,frag_home).commit();

        //4.메뉴 버튼 클릭시 화면 전환하는 기능 구현
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //아이템을 선택하면 동작해라~ 를 구현 한 것

                //선태갛ㄴ 메뉴버튼에 대한 리소스ㅡID저장
                int itemId = item.getItemId();

                if(itemId == R.id.home){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, frag_home)
                            .commit();
                }else if(itemId == R.id.time){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, frag_time)
                            .commit();
                }else{
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, frag_option)
                            .commit();
                }





                return false;
            }
        });
    }
}
