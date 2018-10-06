package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.tmi.R;

public class MainDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        TextView detailSubject = (TextView)findViewById(R.id.subject);
        TextView detailMain = (TextView)findViewById(R.id.main_text);

        Intent intent = getIntent();
        detailSubject.setText(intent.getStringExtra("subject"));
        detailMain.setText(intent.getStringExtra("main_text"));
    }
}
