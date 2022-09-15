package com.lsw.project4;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Ex15SharedPreferencesEx extends AppCompatActivity {
    SharedPreferences pref;          // 프리퍼런스
    SharedPreferences.Editor editor; // 에디터

    String myId; // 아이디 변수

    EditText etId; // 레이아웃 변수 EditText
    CheckBox cbId; // 레이아웃 변수 Button

    Button btnLogin;
    boolean saveLoginData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex15_sharedpreferences);

        // 1. Shared Preference 초기화
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();
        saveLoginData = pref.getBoolean("SAVE_LOGIN_DATA", false);

        // 2. 저장해둔 값 불러오기 ("식별값", 초기값) -> 식별값과 초기값은 직접 원하는 이름과 값으로 작성.
        myId = pref.getString("MyId", "null"); // id 불러오기 (저장해둔 값 없으면 초기값인 null으로 불러옴)

        // 3. 레이아웃 변수 초기화
        etId = (EditText) findViewById(R.id.etId);
        cbId = (CheckBox) findViewById(R.id.cbId);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        if(saveLoginData){
            etId.setText(String.valueOf(myId));
            cbId.setChecked(saveLoginData);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myId = etId.getText().toString();
                editor.putBoolean("SAVE_LOGIN_DATA", cbId.isChecked());
                editor.putString("MyId", myId);
                editor.apply(); // 저장
                Toast.makeText(getApplication(), "로그인 완료!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}