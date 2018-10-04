package com.example.administrator.tmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
