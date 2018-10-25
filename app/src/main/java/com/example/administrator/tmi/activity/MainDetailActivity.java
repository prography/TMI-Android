package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.tmi.R;

public class MainDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        Button BackButton = (Button)findViewById(R.id.back_button);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView detailSubject = (TextView)findViewById(R.id.subject);
        TextView detailMain = (TextView)findViewById(R.id.main_text);
        TextView detailName = (TextView)findViewById(R.id.nickname);
        TextView detailDate = (TextView)findViewById(R.id.date_text);
        TextView detailTags = (TextView)findViewById(R.id.tags);

        Intent intent = getIntent();
        detailSubject.setText(intent.getStringExtra("subject"));
        detailMain.setText(intent.getStringExtra("mainText"));
        detailName.setText(intent.getStringExtra("nickname"));
        detailDate.setText(intent.getStringExtra("date"));
        detailTags.setText(intent.getStringExtra("tags"));
    }
}