package com.best.cy.uimadebycode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mLayout = new LinearLayout(this); //layout 객체 생성
        mLayout.setOrientation(LinearLayout.VERTICAL); //뷰들을 배치 방향 결정 HORIZONTAL: 수평 , VERTICAL : 수직

        TextView t1 = new TextView(this);
        t1.setTextSize(30);
        t1.setText("코드만으로 화면 구성");
        mLayout.addView(t1);

        ImageView img1 = new ImageView(this);
        img1.setImageResource(R.drawable.sophia);
        mLayout.addView(img1);
        setContentView(mLayout);

        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.james);
        //img2.setImageAlpha(100); //이미지 투명도

        mLayout.addView(img2);
        setContentView(mLayout);


        setContentView(R.layout.activity_main);
    }
}