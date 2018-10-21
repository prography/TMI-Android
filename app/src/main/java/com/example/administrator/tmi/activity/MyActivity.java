package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.administrator.tmi.R;
import com.example.administrator.tmi.adapter.MyAdapter;
import com.example.administrator.tmi.data.ItemData;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    private RecyclerView myContainerView;
    private RecyclerView savedContainerView;
    private MyAdapter myAdapter;
    private MyAdapter savedAdapter;
    private List<ItemData> myList = new ArrayList<>();
    private List<ItemData> savedList = new ArrayList<>();
    private TextView newsList;
    private Switch alarmSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initView();
        initMyData();
        initSavedData();

    }

    public void initView() {
        myContainerView = (RecyclerView) findViewById(R.id.my_container);
        savedContainerView = (RecyclerView) findViewById(R.id.saved_container);
        newsList = (TextView) findViewById(R.id.news_list);
        alarmSwitch = (Switch) findViewById(R.id.switch_button);

        Button writeButton = (Button) findViewById(R.id.write_button);

        Button myTextButton = (Button) findViewById(R.id.my_text);
        Button savedTextButton = (Button) findViewById(R.id.saved_text);
        Button newsButton = (Button) findViewById(R.id.news);
        Button settingButton = (Button) findViewById(R.id.setting);

        writeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent my1Intent = new Intent(MyActivity.this, WriteActivity.class);
                startActivity(my1Intent);
            }
        });

        myTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContainerView.setVisibility(View.VISIBLE);
                savedContainerView.setVisibility(View.INVISIBLE);
                newsList.setVisibility(View.INVISIBLE);
                alarmSwitch.setVisibility(View.INVISIBLE);
            }
        });

        savedTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContainerView.setVisibility(View.INVISIBLE);
                savedContainerView.setVisibility(View.VISIBLE);
                newsList.setVisibility(View.INVISIBLE);
                alarmSwitch.setVisibility(View.INVISIBLE);
            }
        });

        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContainerView.setVisibility(View.INVISIBLE);
                savedContainerView.setVisibility(View.INVISIBLE);
                newsList.setVisibility(View.VISIBLE);
                alarmSwitch.setVisibility(View.INVISIBLE);
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContainerView.setVisibility(View.INVISIBLE);
                savedContainerView.setVisibility(View.INVISIBLE);
                newsList.setVisibility(View.INVISIBLE);
                alarmSwitch.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initMyData() {
        for (int i = 0; i < 20; i++) {
            ItemData d = new ItemData();
            d.setDateText("10.05");
            d.setNameText("내글호랑나비");
            d.setLikeImageId(R.drawable.heart);
            d.setReplyImageId(R.drawable.reply);
            d.setReplyCount(33);
            d.setSubjectText("내글 내글 내글이다!!!");
            d.setMainText("서울이 차 끌고 가기 막막한 곳으로 손꼽히는 강남! 모르면 손해보는 강남역, 신논현역 인근 주말 주차꿀팁");
            d.setTagsText("#강남 #주말 #주차 꿀팁");
            myList.add(d);
        }

        setMyAdapter(myList);
    }

    private void initSavedData() {
        for (int i = 0; i < 20; i++) {
            ItemData e = new ItemData();
            e.setDateText("10.05");
            e.setNameText("자색호랑나비");
            e.setLikeImageId(R.drawable.heart);
            e.setReplyImageId(R.drawable.reply);
            e.setReplyCount(33);
            e.setSubjectText("저장된 글 리스트");
            e.setMainText("서울이 차 끌고 가기 막막한 곳으로 손꼽히는 강남! 모르면 손해보는 강남역, 신논현역 인근 주말 주차꿀팁");
            e.setTagsText("#강남 #주말 #주차 꿀팁");
            savedList.add(e);
        }

        setSavedAdapter(savedList);
    }

    private void setMyAdapter(List<ItemData> list) {
        myAdapter = new MyAdapter(this, list);
        myContainerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myContainerView.setAdapter(myAdapter);
    }

    private void setSavedAdapter(List<ItemData> list) {
        savedAdapter = new MyAdapter(this, list);
        savedContainerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        savedContainerView.setAdapter(savedAdapter);
    }
}
