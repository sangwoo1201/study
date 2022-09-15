package com.lsw.project4;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex3VideoActivity extends AppCompatActivity {

    VideoView vv;
    LinearLayout frame1, frame2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_video);

        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);
        vv = (VideoView)findViewById(R.id.videoView);
        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
//        findViewById(R.id.btnAct3).setOnClickListener(mClick);
        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        vv.setMediaController(new MediaController(this));
        vv.setVideoURI(videoUri);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnAct1:
                    vv.start();
                    frame1.setVisibility(View.INVISIBLE);
                    frame2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnAct2:
                    vv.pause();
                    frame1.setVisibility(View.VISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    break;
//                case R.id.btnAct3:
//                    vv.stopPlayback();
//                    break;

            }
        }
    };

}