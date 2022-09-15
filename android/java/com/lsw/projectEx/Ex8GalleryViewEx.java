package com.lsw.project4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Ex8GalleryViewEx extends AppCompatActivity {

        Uri uri;
        ImageView imageView;
        Button selectImageBtn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_ex8_galleryview);

            selectImageBtn = findViewById(R.id.btnGetPic);
            imageView = findViewById(R.id.imageView);
            findViewById(R.id.btnGetPic).setOnClickListener(mClick);
        }
        View.OnClickListener mClick = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.btnGetPic:
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityResult.launch(intent);
                        break;

                }

            }
        };
        ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if( result.getResultCode() == RESULT_OK && result.getData() != null){

                            uri = result.getData().getData();

                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                                imageView.setImageBitmap(bitmap);

                            }catch (FileNotFoundException e){
                                e.printStackTrace();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }