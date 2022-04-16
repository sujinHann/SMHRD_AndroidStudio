package com.example.ex0414;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//Alt + Enter : 추상메소드를 구현해야 하거나 import할 때 사용하는 단축키
// 어댑터의 역할
// - 리스트뷰에 보여질 아이템뷰를 생성해주는 역할
// - 아이템뷰와 데이터를 묶어서 View객체로 생성

public class ContactAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<ContactVO> list;
    LayoutInflater inflater; //xml 파일을 --> View 객체로 변환해주는 객체

    public ContactAdapter(Context context, int layout, ArrayList<ContactVO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //아이템뷰와 데이터를 바인딩해주는 메소드
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;


        //1. list_item.xml -> view 객체로 변환
        if(view == null){
            view = inflater.inflate(layout, viewGroup, false);

            //아이템뷰에 배치된 View 객체들을 한 번 초기화
            holder = new ViewHolder(view);

            //초기화된 holder객체를 view객체에 태그 저장
            view.setTag(holder);
        } else {

            holder = (ViewHolder) view.getTag();
        }
        //2. list_item.xml 안에 있는 ImagView, TextView, Button 초기화
//        ImageView imageView = view.findViewById(R.id.imageView);
//        TextView tvName = view.findViewById(R.id.tvName);
//        TextView tvPhone = view.findViewById(R.id.tvPhone);
//        ImageButton btnCall = view.findViewById(R.id.btnCall);

        //3. 생성된 View 객체를 활용
        ContactVO vo = (ContactVO) getItem(i);
        holder.getImageView().setImageResource(vo.getImg());
        //imageView.setImageResource(vo.getImg());
        holder.getTvName().setText(vo.getName());
        //tvName.setText(vo.getName());
        holder.getTvPhone().setText(vo.getPhone());
        //tvPhone.setText(vo.getPhone());

        holder.getBtnCall().setOnClickListener(new View.OnClickListener() {
        //btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //context -> ContactActivity를 가리키는 객체
                Toast.makeText(context,vo.getPhone(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,MainActivity.class);

                //ContactAdapter는 액티비티가 아닌 일반클래스이기 때문에
                //액티비티에서만 사용할 수 있는 메소드를 바로 호출이 불가능!
                //사용하려면 액티비티정보를 가진 Context객체를 통해서 사용가능!
                context.startActivity(intent);


            }
        });

        //4. 생성된 Layout View객체를 리턴! --> ListView에 출력
        return view; //★★★★★
    }
}
