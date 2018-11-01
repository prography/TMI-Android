package com.example.administrator.tmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.tmi.R;

public class WriteActivity extends AppCompatActivity {


    ImageButton backBtn;
    Button okBtn;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);


        initView();
        setData();


    }

    private void setData() {
    }


    private void initView() {
        backBtn = (ImageButton)findViewById(R.id.search_back_button);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
