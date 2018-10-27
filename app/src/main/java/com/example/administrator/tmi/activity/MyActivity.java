package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
    private LinearLayout newsList;
    private LinearLayout alarmSwitch;


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
        newsList = (LinearLayout) findViewById(R.id.news_list);
        alarmSwitch = (LinearLayout) findViewById(R.id.switch_button);

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
        ItemData d = new ItemData();
        d.setDateText("10.20");
        d.setNameText("조완주");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("커피 마실 때 주의할 점");
        d.setMainText("호올스를 먹고 시원한 커피를 마시면 목이 아프다");
        d.setTagsText("#커피 #호올스");
        myList.add(d);

        d = new ItemData();
        d.setDateText("10.19");
        d.setNameText("신성환");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("술 마실 때 의외로 어울리는 과일 안주");
        d.setMainText("귤이 의외로 술과 잘 어울린다");
        d.setTagsText("#술 #안주 #귤");
        myList.add(d);

        d = new ItemData();
        d.setDateText("10.18");
        d.setNameText("김애리");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("김치볶음밥 맛있는 곳");
        d.setMainText("강남역 코다차야 많이 맛있다");
        d.setTagsText("#강남 #코다차야 #김치볶음밥");
        myList.add(d);

        d = new ItemData();
        d.setDateText("10.17");
        d.setNameText("강찬");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("퇴근시간 평택역에서 서울 갈 때 유의할 점");
        d.setMainText("시외버스를 타면 차가 막혀서 지하철보다 오래 걸린다");
        d.setTagsText("#평택역 #시외버스 #서울");
        myList.add(d);

        d = new ItemData();
        d.setDateText("10.16");
        d.setNameText("하태린");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("아메리카노 맛없는 곳");
        d.setMainText("스타벅스 아메리카노는 정말 맛없다");
        d.setTagsText("#스타벅스 #아메리카노");
        myList.add(d);

        d = new ItemData();
        d.setDateText("10.15");
        d.setNameText("박서연");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("나의 최애캐 만들기");
        d.setMainText("모바일 어플 '나의 최애캐'에서 만들 수 있다");
        d.setTagsText("#프사 #최애캐 #어플");
        myList.add(d);

        d = new ItemData();
        d.setDateText("10.14");
        d.setNameText("허유경");
        d.setLikeImageId(R.drawable.heart);
        d.setReplyImageId(R.drawable.reply);
        d.setReplyCount(33);
        d.setSubjectText("이대 앞 커리야");
        d.setMainText("1인 1메뉴를 시키면 리필이 가능한데 메뉴를 바꿔서 리필이 가능하다");
        d.setTagsText("#이대 #맛집 #리필");
        myList.add(d);

        for (int i = 0; i < 20; i++) {
            d = new ItemData();
            d.setDateText("10.00");
            d.setNameText("더미데이터 작성자");
            d.setLikeImageId(R.drawable.heart);
            d.setReplyImageId(R.drawable.reply);
            d.setReplyCount(33);
            d.setSubjectText("더미데이터 내 글 제목");
            d.setMainText("더미데이터 내 글 내용 더미데이터 내 글 내용 더미데이터 내 글 내용 더미데이터 내 글 내용 더미데이터 내 글 내용 ");
            d.setTagsText("#더미 #데이터 #태그");
            myList.add(d);
        }

        setMyAdapter(myList);
    }

    private void initSavedData() {
        ItemData e = new ItemData();
        e.setDateText("10.14");
        e.setNameText("허유경");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("이대 앞 커리야");
        e.setMainText("1인 1메뉴를 시키면 리필이 가능한데 메뉴를 바꿔서 리필이 가능하다");
        e.setTagsText("#이대 #맛집 #리필");
        savedList.add(e);

        e = new ItemData();
        e.setDateText("10.15");
        e.setNameText("박서연");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("나의 최애캐 만들기");
        e.setMainText("모바일 어플 '나의 최애캐'에서 만들 수 있다");
        e.setTagsText("#프사 #최애캐 #어플");
        savedList.add(e);

        e = new ItemData();
        e.setDateText("10.16");
        e.setNameText("하태린");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("아메리카노 맛없는 곳");
        e.setMainText("스타벅스 아메리카노는 정말 맛없다");
        e.setTagsText("#스타벅스 #아메리카노");
        savedList.add(e);

        e = new ItemData();
        e.setDateText("10.17");
        e.setNameText("강찬");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("퇴근시간 평택역에서 서울 갈 때 유의할 점");
        e.setMainText("시외버스를 타면 차가 막혀서 지하철보다 오래 걸린다");
        e.setTagsText("#평택역 #시외버스 #서울");
        savedList.add(e);

        e = new ItemData();
        e.setDateText("10.18");
        e.setNameText("김애리");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("김치볶음밥 맛있는 곳");
        e.setMainText("강남역 코다차야 많이 맛있다");
        e.setTagsText("#강남 #코다차야 #김치볶음밥");
        savedList.add(e);

        e = new ItemData();
        e.setDateText("10.19");
        e.setNameText("신성환");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("술 마실 때 의외로 어울리는 과일 안주");
        e.setMainText("귤이 의외로 술과 잘 어울린다");
        e.setTagsText("#술 #안주 #귤");
        savedList.add(e);

        e = new ItemData();
        e.setDateText("10.20");
        e.setNameText("조완주");
        e.setLikeImageId(R.drawable.heart);
        e.setReplyImageId(R.drawable.reply);
        e.setReplyCount(33);
        e.setSubjectText("커피 마실 때 주의할 점");
        e.setMainText("호올스를 먹고 시원한 커피를 마시면 목이 아프다");
        e.setTagsText("#커피 #호올스");
        savedList.add(e);

        for (int i = 0; i < 20; i++) {
            e = new ItemData();
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
