package com.example.administrator.tmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.tmi.R;

public class WriteActivity extends AppCompatActivity {


    Button backBtn;
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
        backBtn = (Button)findViewById(R.id.button3);
        okBtn = (Button)findViewById(R.id.button5);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText.getText().toString();
                String content = editText2.getText().toString();

                Toast.makeText(WriteActivity.this,title,Toast.LENGTH_SHORT).show();
                Toast.makeText(WriteActivity.this,content,Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
