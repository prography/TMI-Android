package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.administrator.tmi.data.ItemData;
import com.example.administrator.tmi.adapter.MyAdapter;
import com.example.administrator.tmi.R;
import com.example.administrator.tmi.retrofit.RetrofitClient;
import com.example.administrator.tmi.retrofit.service.TmiService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView containerView;
    MyAdapter mAdapter;
    List<ItemData> itemList = new ArrayList<>();
    private TmiService tmiService = RetrofitClient.create().create(TmiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containerView = (RecyclerView)findViewById(R.id.main_recycler_container);

        initData();

        ImageButton btn = (ImageButton) findViewById(R.id.main_write);
        ImageButton myBtn = (ImageButton) findViewById(R.id.main_mine);

        mAdapter = new MyAdapter(this, itemList);
        RecyclerView.LayoutManager manager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        containerView.setLayoutManager(manager);
        containerView.setAdapter(mAdapter);

        ImageView searchText = (ImageView)findViewById(R.id.main_search);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), MyActivity.class);
                startActivity(myIntent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent my1Intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(my1Intent);
            }
        });
    }

    private void initData(){
        ItemData d = new ItemData();
        d.setDateText("10.20");
        d.setNameText("조완주");
        d.setReplyCount(33);
        d.setSubjectText("커피 마실 때 주의할 점");
        d.setMainText("호올스를 먹고 시원한 커피를 마시면 목이 아프다");
        d.setTagsText("#커피 #호올스");
        itemList.add(d);

        d = new ItemData();
        d.setDateText("10.19");
        d.setNameText("신성환");
        d.setReplyCount(33);
        d.setSubjectText("술 마실 때 의외로 어울리는 과일 안주");
        d.setMainText("귤이 의외로 술과 잘 어울린다");
        d.setTagsText("#술 #안주 #귤");
        itemList.add(d);

        d = new ItemData();
        d.setDateText("10.18");
        d.setNameText("김애리");
        d.setReplyCount(33);
        d.setSubjectText("김치볶음밥 맛있는 곳");
        d.setMainText("강남역 코다차야 많이 맛있다");
        d.setTagsText("#강남 #코다차야 #김치볶음밥");
        itemList.add(d);

        d = new ItemData();
        d.setDateText("10.17");
        d.setNameText("강찬");
        d.setReplyCount(33);
        d.setSubjectText("퇴근시간 평택역에서 서울 갈 때 유의할 점");
        d.setMainText("시외버스를 타면 차가 막혀서 지하철보다 오래 걸린다");
        d.setTagsText("#평택역 #시외버스 #서울");
        itemList.add(d);

        d = new ItemData();
        d.setDateText("10.16");
        d.setNameText("하태린");
        d.setReplyCount(33);
        d.setSubjectText("아메리카노 맛없는 곳");
        d.setMainText("스타벅스 아메리카노는 정말 맛없다");
        d.setTagsText("#스타벅스 #아메리카노");
        itemList.add(d);

        d = new ItemData();
        d.setDateText("10.15");
        d.setNameText("박서연");
        d.setReplyCount(33);
        d.setSubjectText("나의 최애캐 만들기");
        d.setMainText("모바일 어플 '나의 최애캐'에서 만들 수 있다");
        d.setTagsText("#프사 #최애캐 #어플");
        itemList.add(d);

        d = new ItemData();
        d.setDateText("10.14");
        d.setNameText("허유경");
        d.setReplyCount(33);
        d.setSubjectText("이대 앞 커리야");
        d.setMainText("1인 1메뉴를 시키면 리필이 가능한데 메뉴를 바꿔서 리필이 가능하다");
        d.setTagsText("#이대 #맛집 #리필");
        itemList.add(d);

        for(int i=0;i<20;i++){
            d = new ItemData();
            d.setDateText("10.00");
            d.setNameText("더미데이터 작성자");
            d.setReplyCount(33);
            d.setSubjectText("더미데이터 제목");
            d.setMainText("더미데이터 내용 더미데이터 내용 더미데이터 내용 더미데이터 내용 더미데이터 내용 ");
            d.setTagsText("#더미 #데이터 #태그");
            itemList.add(d);
        }
    }
}
