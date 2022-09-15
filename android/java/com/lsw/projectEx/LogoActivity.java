package com.lsw.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
public class LogoActivity extends AppCompatActivity {

    LinearLayout frame_logo, frame_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000); //1초 후 인트로 실행
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnEx1:
                    break;
            }
        }
    };
}