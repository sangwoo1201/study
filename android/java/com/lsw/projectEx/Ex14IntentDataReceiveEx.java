package com.lsw.project4;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Ex14IntentDataReceiveEx extends AppCompatActivity {
    TextView tvName, tvAge, tvHp, tvLocation;

    String data1, data2, data3, data4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex14_intent_receive);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvHp = (TextView) findViewById(R.id.tvHp);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        Intent getIntent = getIntent();
        data1= getIntent.getStringExtra("data1");
        data2= getIntent.getStringExtra("data2");
        data3= getIntent.getStringExtra("data3");
        data4= getIntent.getStringExtra("data4");

        tvName.setText(data1);
        tvAge.setText(data2);
        tvHp.setText(data3);
        tvLocation.setText(data4);

    }
}