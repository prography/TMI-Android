package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.tmi.data.ItemData;
import com.example.administrator.tmi.adapter.MyAdapter;
import com.example.administrator.tmi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView containerView;
    MyAdapter mAdapter;
    List<ItemData> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containerView = (RecyclerView)findViewById(R.id.recycler_container);

        initData();

        Button btn = (Button)findViewById(R.id.button2);
        Button myBtn = (Button)findViewById(R.id.button);

        mAdapter = new MyAdapter(this, itemList);
        RecyclerView.LayoutManager manager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        containerView.setLayoutManager(manager);
        containerView.setAdapter(mAdapter);








        TextView searchText = (TextView)findViewById(R.id.search_text);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        Button searchButton = (Button)findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, MyActivity.class);
                startActivity(myIntent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent my1Intent = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(my1Intent);
            }
        });
    }

    private void initData(){
        for(int i=0;i<20;i++){
            ItemData d = new ItemData();
            d.setDateText("10.05");
            d.setNameText("자색호랑나비");
            d.setLikeImageId(R.drawable.heart);
            d.setReplyImageId(R.drawable.reply);
            d.setReplyCount(33);
            d.setSubjectText("강남역 인근 주말 주차 장소 추천");
            d.setMainText("서울이 차 끌고 가기 막막한 곳으로 손꼽히는 강남! 모르면 손해보는 강남역, 신논현역 인근 주말 주차꿀팁");
            d.setTagsText("#강남 #주말 #주차 꿀팁");
            itemList.add(d);
        }

    }
}
