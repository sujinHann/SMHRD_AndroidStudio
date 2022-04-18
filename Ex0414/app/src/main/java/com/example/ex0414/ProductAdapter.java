package com.example.ex0414;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    int item_layout;
    ArrayList<ProductVO> list;
    LayoutInflater inflater; //xml 파일을 --> View 객체로 변환해주는 객체

    public ProductAdapter(Context context, int layout, ArrayList<ProductVO> list) {
        this.context = context;
        this.item_layout = layout;
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

        ProViewHolder holder = null;


        if(view == null){
            view = inflater.inflate(item_layout, viewGroup, false);

            holder = new ProViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ProViewHolder) view.getTag();
        }

        ProductVO vo = list.get(i);

        holder.getImgPro().setImageResource(vo.getImage());
        holder.getTvProName().setText(vo.getPro_name());
        holder.getTvProCount().setText(vo.getPro_count());


        holder.getBtnProDetail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자 : AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("상품 보기")
                        .setMessage("상품개수 : "+vo.getPro_count())
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

                Toast.makeText(context,vo.getPro_name(),Toast.LENGTH_SHORT).show();


            }
        });


        //4. 생성된 Layout View객체를 리턴! --> ListView에 출력
        return view; //★★★★★
    }





}
