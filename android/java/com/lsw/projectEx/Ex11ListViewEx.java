package com.lsw.project4;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Ex11ListViewEx extends AppCompatActivity {
    private String TAG = "리스트뷰예제";
    private ListView listview = null;
    private ListViewAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11_listview);

        listview = (ListView) findViewById(R.id.listview);
        adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Ex11PokemonItem("1", "파이리", R.drawable.po1, "01012341234", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("2", "꼬부기", R.drawable.po2, "01023231212", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("3", "이상해씨", R.drawable.po3, "01045678912", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("4", "피카츄", R.drawable.po4, "01015896542", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("5", "리자몽", R.drawable.po5, "01023568914", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("6", "거북왕", R.drawable.po6, "01046581598", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("7", "이상해꽃", R.drawable.po7, "01078945612", R.drawable.call));
        adapter.addItem(new Ex11PokemonItem("8", "뮤", R.drawable.po8, "01012345678", R.drawable.call));
        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }


    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Ex11PokemonItem> items = new ArrayList<Ex11PokemonItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Ex11PokemonItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final Ex11PokemonItem pokemonItem = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.ex11_listview_list_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            ImageView iv_call = (ImageView) convertView.findViewById(R.id.iv_call);

            tv_num.setText(pokemonItem.getNum());
            tv_name.setText(pokemonItem.getName());
            iv_icon.setImageResource(pokemonItem.getResId());
            iv_call.setImageResource(pokemonItem.getResId2());

            Log.d(TAG, "getView() - [ "+position+" ] "+pokemonItem.getName());

            //각 아이템 선택 event
            iv_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, pokemonItem.getNum()+" 번 - "+pokemonItem.getName()+"에게 전화를 겁니다~", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+pokemonItem.getTel()));
                    startActivity(intent);
                }
            });
            return convertView;  //뷰 객체 반환
        }
    }
    }