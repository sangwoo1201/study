package com.lsw.project4;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Ex2GifActivity extends AppCompatActivity {

    ImageView ivTest,ivTest2,ivTest3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_gif);

        ivTest = (ImageView)findViewById(R.id.imageView);
        Glide.with(Ex2GifActivity.this).load(R.drawable.ban).into(ivTest);
    }

}