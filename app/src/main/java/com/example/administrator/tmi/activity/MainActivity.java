package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.tmi.data.ItemData;
import com.example.administrator.tmi.adapter.MyAdapter;
import com.example.administrator.tmi.R;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        mAdapter = new MyAdapter(this);
        listView.setAdapter(mAdapter);
        initData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(),MainDetail.class);
                intent.putExtra("subject", MyAdapter.items.get(position).subjectText);
                intent.putExtra("main_text", MyAdapter.items.get(position).mainText);
                startActivity(intent);
            }
        });
    }

    private void initData(){
        for(int i=0;i<20;i++){
            ItemData d = new ItemData();
            d.dateText = "10.05";
            d.nameText = "자색호랑나비";
            d.likeImageId = R.drawable.heart;
            d.replyImageId = R.drawable.reply;
            d.replyCount = 33;
            d.subjectText = "강남역 인근 주말 주차 장소 추천";
            d.mainText = "서울이 차 끌고 가기 막막한 곳으로 손꼽히는 강남! 모르면 손해보는 강남역, 신논현역 인근 주말 주차꿀팁";
            d.tagsText = "#강남 #주말 #주차 꿀팁";
            mAdapter.add(d);
        }

    }
}
