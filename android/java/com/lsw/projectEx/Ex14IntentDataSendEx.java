package com.lsw.project4;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Ex14IntentDataSendEx extends AppCompatActivity {

    EditText etName, etAge, etHp, etLocation;
    String data1="noName";
    String data2="noAge";
    String data3="noHp";
    String data4="noLocation";
    String[] items = new String[100];
    String temp = "";//스피너 선택값 저장변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex14_intent_send);

        for(int i=0; i<items.length; i++){
            items[i] = Integer.toString(i);
        }
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);
        etLocation = (EditText) findViewById(R.id.etLocation);

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
                temp = items[position];
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                temp = "0";
            }
        });

        findViewById(R.id.btn).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btn:
                    if(!etName.getText().toString().equals("")){
                        data1=etName.getText().toString();
                    }
                    if(!temp.equals("")){
                        data2=temp;
                    }
                    if(!etHp.getText().toString().equals("")){
                        data3=etHp.getText().toString();
                    }
                    if(!etLocation.getText().toString().equals("")){
                        data4=etLocation.getText().toString();
                    }
                    Intent ex14 = new Intent(Ex14IntentDataSendEx.this, com.lsw.project4.Ex14IntentDataReceiveEx.class);
                    ex14.putExtra("data1",data1);
                    ex14.putExtra("data2",data2);
                    ex14.putExtra("data3",data3);
                    ex14.putExtra("data4",data4);
                    startActivity(ex14);
                    break;
            }

        }
    };
}