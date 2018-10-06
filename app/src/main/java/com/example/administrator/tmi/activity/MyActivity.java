package com.example.administrator.tmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.tmi.R;

public class MyActivity extends AppCompatActivity {


    TextView name;
    TextView write;
    TextView comment;
    TextView like;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initView();
        setData();

    }

    private void initView() {
         name = (TextView)findViewById(R.id.textView5);
         write = (TextView)findViewById(R.id.textView8);
         comment = (TextView)findViewById(R.id.textView10);
         like = (TextView)findViewById(R.id.textView12);

    }

    private void setData(){
        name.setText("야호");
        write.setText("2");
        comment.setText("3");
        like.setText("5");
    }
}
