package com.lsw.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Ex6TelActivity extends AppCompatActivity {

    EditText edit_tel;
    Button btn_tel2,btn_tel3,btn_tel4,btn_tel5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex6_call);

        btn_tel2 = findViewById(R.id.btn_tel2);
        btn_tel3 = findViewById(R.id.btn_tel3);
        btn_tel4 = findViewById(R.id.btn_tel4);
        btn_tel5 = findViewById(R.id.btn_tel5);
        edit_tel = findViewById(R.id.edit_tel);

        findViewById(R.id.btn1).setOnClickListener(mClick);
        findViewById(R.id.btn_tel2).setOnClickListener(mClick);
        findViewById(R.id.btn_tel3).setOnClickListener(mClick);
        findViewById(R.id.btn_tel4).setOnClickListener(mClick);
        findViewById(R.id.btn_tel5).setOnClickListener(mClick);
        //전화번호 표시로 변경해주기
        edit_tel.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn1:
                    String tel_number = "tel:"+edit_tel.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number));
                    startActivity(intent);
                    break;
                case R.id.btn_tel2:
                    Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01082828282"));
                    startActivity(intent2);
                    break;
                case R.id.btn_tel3:
                    Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01012341234"));
                    startActivity(intent3);
                    break;
                case R.id.btn_tel4:
                    Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01012312312"));
                    startActivity(intent4);
                    break;
                case R.id.btn_tel5:
                    Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"01045645645"));
                    startActivity(intent5);
                    break;

            }

        }
    };
}