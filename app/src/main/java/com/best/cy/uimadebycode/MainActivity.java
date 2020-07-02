package com.best.cy.uimadebycode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static int lapseMin;
    static long startTime;
    static long endTime;
    static int randomMin;

    static SoundPool sdPool;
    static int soundOfBomb;

    static MediaPlayer backMusic;

    Button b1;
    Button b2;

    static int width;
    static int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //화면 가로, 세로 크기 얻기
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        //폭탄 터지는 효과음
        sdPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundOfBomb = sdPool.load(this, R.raw.bomb, 2); //반환 값은 sound ID

        //시계 째깍째깍 소리
        backMusic = MediaPlayer.create(this, R.raw.crack);
        backMusic.setLooping(true); //노래를 무한반복으로 나오게 하기
        backMusic.start();

        //게임 시작 버튼
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //폭탄이 터지는 시간을 5~84초 사이로 설정한다.
                randomMin = new Random().nextInt(80) + 5;
                startTime = System.currentTimeMillis();
                MyView.gameOver = false; //게임 진행중을 의미
                MyView.sayBomb = false; //시계 째깍째깍 소리 나게 하기
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                backMusic.stop(); //배경 음악 끄기
                finish(); //Activity 종료
            }
        });
    }

    //게임 시작 후 지나간 시간을 구한다.
    public static void checkMin() {
        endTime = System.currentTimeMillis();
        lapseMin = (int) endTime - (int) startTime;
        lapseMin = lapseMin / 1000;
    }

    //폭탄이 터지게 되면 호출되어 째깍째깍 소리 멈추기
    public static void stopBackSound() {
        backMusic.pause();
    }

    //폭탄이 터지게 되면 호출되어 폭탄 효과음 나기
    public static void sayBomb() {
        sdPool.play(soundOfBomb, 1.0f,1.0f,1,0,1.0f);
    }
}