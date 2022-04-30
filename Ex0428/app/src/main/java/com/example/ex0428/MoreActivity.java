package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MoreActivity extends AppCompatActivity {

    ImageView[] moreArr = new ImageView[9];
    TextView tvTime, tvCount;
    boolean isPlaying = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


        tvTime = findViewById(R.id.tvTime);
        tvCount = findViewById(R.id.tvCount);

        //동적으로 리소스ID 접근 후 ImageView 초기화
        for (int i = 0; i < moreArr.length; i++) {

            final int pos = i;

            //img1~img9까지의 리소스 id접근
            int resId = getResources().getIdentifier("img" + (i + 1), "id", getPackageName());
            moreArr[i] = findViewById(resId);

            //imageView에 tag설정
            //tag: View에 대한 상태값 저장
            moreArr[i].setTag("down");

            //만든 쓰레드 호출
            MrhongMoveThread thread = new MrhongMoveThread(i);
            thread.start();
            MrhongTimerThread thread1 = new MrhongTimerThread();
            thread1.start();

            //두더지(imageView)를 클릭 했을때
            moreArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String status = moreArr[pos].getTag().toString();

                    //두더지의 상태체크 -> 잡은 개수를 업데이트 증감
                    // 잡은개수에 대한 카운트 기능을 구현하시오

                    int score = Integer.parseInt(tvCount.getText().toString());

                    if (status.equals("up")) {
                        score += 1;

                    } else {
                        if (score > 0) {
                            score -= 1;
                        }
                    }

                    tvCount.setText(String.valueOf(score));

                }
            });
        }


    } //end

    //스레드 상속받으면  run 메소드 필요
    class MrhongMoveThread extends Thread {

        MrhongMoveHandler handler = new MrhongMoveHandler();

        int hong_pos;

        public MrhongMoveThread(int hong_pos) {
            this.hong_pos = hong_pos;
        }


        @Override
        public void run() {

            // 두더지가 위/아래 머물러 있는 시간 랜덤으로 생성하시오
            Random ran = new Random();

//            int downTime = new Random().nextInt(5000);
//            int upTime = new Random().nextInt(5000);

            while (isPlaying){

                int downTime = ran.nextInt(1500) + 500;
                int upTime = ran.nextInt(1500) + 500;

                //아래 머물러 있는 시간
                try {
                    Thread.sleep(downTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //저장해야 할 데이터: 두더지번호, 변경할 두더지 이미지, 두더지 상태
                Message msg = new Message();
                msg.arg1 = hong_pos;
                msg.arg2 = R.drawable.up;
                msg.obj = "up";

                handler.sendMessage(msg);

                //위 머물러 있는 시간
                try {
                    Thread.sleep(upTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                msg = new Message();
                msg.arg1 = hong_pos;
                msg.arg2 = R.drawable.down;
                msg.obj = "down";

                handler.sendMessage(msg);

            } //end while
        }
    }//end

    class MrhongMoveHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {

            int pos = msg.arg1;
            int img = msg.arg2;
            String status = (String) msg.obj;

            moreArr[pos].setImageResource(img);
            moreArr[pos].setTag(status);

        }
    } //end


    class MrhongTimerThread extends Thread {

        MrhongTimerHandler handler = new MrhongTimerHandler();

        @Override
        public void run() {
            for (int i = 30; i >= 0; i--) {
                Message msg = new Message();
                msg.arg1 = i;

                handler.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }

    class MrhongTimerHandler extends Handler {
            @Override
            public void handleMessage(@NonNull Message msg) {

                int timeCount = msg.arg1;
                tvTime.setText(String.valueOf(timeCount));

                //0초가 되었을때 두더지 움직임 정지
                if(timeCount==0){
                    isPlaying = false;
                }

            }
        } //end


}
