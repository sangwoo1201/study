package com.lsw.project4;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Ex12SpinnerEx extends AppCompatActivity {
    TextView textView;
    String[] items = {"파이리","꼬부기","이상해씨","피카츄","리자몽","거북왕","이상해꽃","뮤"};
    String temp = "";//스피너 선택값 저장변수
    Integer[] pokemon = {R.drawable.po1,R.drawable.po2,R.drawable.po3,R.drawable.po4,R.drawable.po5,R.drawable.po6,R.drawable.po7,R.drawable.po8};
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_spinner);

        textView = (TextView) findViewById(R.id.tvSel);
        imageView = (ImageView) findViewById(R.id.iv_po);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
                imageView.setImageResource(pokemon[position]);

                temp = items[position];
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");
            }
        });

    }
}