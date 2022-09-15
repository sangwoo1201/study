package com.lsw.project4;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex5WebViewActivity extends AppCompatActivity {

    TextView tvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_web_view);

        tvMsg = (TextView)findViewById(R.id.tvMsg);
        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
        findViewById(R.id.btnAct3).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnAct1:
                    tvMsg.setText("구글 접속!");
                    Intent act1 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExGoogle.class);
                    startActivity(act1);
                    break;
                case R.id.btnAct2:
                    tvMsg.setText("유튜브접속!");
                    Intent act2 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExYoutube.class);
                    startActivity(act2);
                    break;
                case R.id.btnAct3:
                    tvMsg.setText("네이버접속함");
                    Intent act3 = new Intent(Ex5WebViewActivity.this, Ex5WebViewExNaver.class);
                    startActivity(act3);
                    break;

            }
        }
    };

}