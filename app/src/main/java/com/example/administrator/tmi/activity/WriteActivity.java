package com.example.administrator.tmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.tmi.R;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        Button backBtn = (Button)findViewById(R.id.button3);
        Button okBtn = (Button)findViewById(R.id.button5);
        final EditText title = (EditText)findViewById(R.id.editText);
        final EditText text = (EditText)findViewById(R.id.editText2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WriteActivity.this,title.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(WriteActivity.this,text.getText(),Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
