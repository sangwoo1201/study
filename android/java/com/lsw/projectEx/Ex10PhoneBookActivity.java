package com.lsw.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Ex10PhoneBookActivity extends AppCompatActivity {

    LinearLayout frame1, frame2, frame3, frame4, frame5,
            frame6, frame7, frame8, frame9, frame10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_phone_book);

        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);
        frame3 = (LinearLayout)findViewById(R.id.frame3);
        frame4 = (LinearLayout)findViewById(R.id.frame4);
        frame5 = (LinearLayout)findViewById(R.id.frame5);
        frame6 = (LinearLayout)findViewById(R.id.frame6);
        frame7 = (LinearLayout)findViewById(R.id.frame7);
        frame8 = (LinearLayout)findViewById(R.id.frame8);
        frame9 = (LinearLayout)findViewById(R.id.frame9);
        frame10 = (LinearLayout)findViewById(R.id.frame10);


        findViewById(R.id.frame1).setOnClickListener(mClick);
        findViewById(R.id.frame2).setOnClickListener(mClick);
        findViewById(R.id.frame3).setOnClickListener(mClick);
        findViewById(R.id.frame4).setOnClickListener(mClick);
        findViewById(R.id.frame5).setOnClickListener(mClick);
        findViewById(R.id.frame6).setOnClickListener(mClick);
        findViewById(R.id.frame7).setOnClickListener(mClick);
        findViewById(R.id.frame8).setOnClickListener(mClick);
        findViewById(R.id.frame9).setOnClickListener(mClick);
        findViewById(R.id.frame10).setOnClickListener(mClick);
        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn2).setOnClickListener(mClick);
        findViewById(R.id.btn3).setOnClickListener(mClick);
        findViewById(R.id.btn4).setOnClickListener(mClick);
        findViewById(R.id.btn5).setOnClickListener(mClick);
        //전화번호 표시로 변경해주기
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            frame1.setVisibility(View.VISIBLE);
            frame2.setVisibility(View.INVISIBLE);
            frame3.setVisibility(View.VISIBLE);
            frame4.setVisibility(View.INVISIBLE);
            frame5.setVisibility(View.VISIBLE);
            frame6.setVisibility(View.INVISIBLE);
            frame7.setVisibility(View.VISIBLE);
            frame8.setVisibility(View.INVISIBLE);
            frame9.setVisibility(View.VISIBLE);
            frame10.setVisibility(View.INVISIBLE);
            switch(v.getId())
            {
                case R.id.frame1:
                    frame1.setVisibility(View.INVISIBLE);
                    frame2.setVisibility(View.VISIBLE);
                    break;
                case R.id.frame2:
                    frame1.setVisibility(View.VISIBLE);
                    frame2.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btn1:
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01012341234"));
                    startActivity(intent);
                    break;
                case R.id.frame3:
                    frame3.setVisibility(View.INVISIBLE);
                    frame4.setVisibility(View.VISIBLE);
                    break;
                case R.id.frame4:
                    frame3.setVisibility(View.VISIBLE);
                    frame4.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btn2:
                    Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01012312344"));
                    startActivity(intent2);
                    break;
                case R.id.frame5:
                    frame5.setVisibility(View.INVISIBLE);
                    frame6.setVisibility(View.VISIBLE);
                    break;
                case R.id.frame6:
                    frame5.setVisibility(View.VISIBLE);
                    frame6.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btn3:
                    Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01011234234"));
                    startActivity(intent3);
                    break;
                case R.id.frame7:
                    frame7.setVisibility(View.INVISIBLE);
                    frame8.setVisibility(View.VISIBLE);
                    break;
                case R.id.frame8:
                    frame7.setVisibility(View.VISIBLE);
                    frame8.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btn4:
                    Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01015678234"));
                    startActivity(intent4);
                    break;
                case R.id.frame9:
                    frame9.setVisibility(View.INVISIBLE);
                    frame10.setVisibility(View.VISIBLE);
                    break;
                case R.id.frame10:
                    frame9.setVisibility(View.VISIBLE);
                    frame10.setVisibility(View.INVISIBLE);
                    break;
                case R.id.btn5:
                    Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01012356784"));
                    startActivity(intent5);
                    break;

            }

        }
    };
}