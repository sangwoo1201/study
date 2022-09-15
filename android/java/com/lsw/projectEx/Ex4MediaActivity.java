package com.lsw.project4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex4MediaActivity extends AppCompatActivity {

    MediaPlayer player;
    LinearLayout frame1, frame2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_media);

        player = MediaPlayer.create(Ex4MediaActivity.this, R.raw.blackpink_pink_venom);
        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);
        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
        //findViewById(R.id.btnAct3).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnAct1:
                    player.start();
                    frame1.setVisibility(View.INVISIBLE);
                    frame2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnAct2:
                    player.pause();
                    frame1.setVisibility(View.VISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    break;
//                case R.id.btnAct3:
//                    tvMsg.setText("음악이 중지되었습니다.");
//                    player.stop();
//                    break;

            }
        }
    };

}