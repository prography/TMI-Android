package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tmi.DatabaseHelper;
import com.example.administrator.tmi.R;
import com.example.administrator.tmi.data.Member;

public class JoinActivity extends AppCompatActivity {
    int version = 1;
    DatabaseHelper helper;
    SQLiteDatabase database;

    EditText emailEditText;
    EditText pwEditText;
    EditText pwCheckEditText;
    Button joinButton;
    Button LoginButton;

    String sql;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        emailEditText = (EditText)findViewById(R.id.signup_id);
        pwEditText = (EditText)findViewById(R.id.signup_pass);
        pwCheckEditText = (EditText)findViewById(R.id.signup_pass_conf);
        joinButton = (Button)findViewById(R.id.signup_signup);
        LoginButton = (Button)findViewById(R.id.signup_login);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        helper = new DatabaseHelper(JoinActivity.this);
        database = helper.getWritableDatabase();


        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String pw = pwEditText.getText().toString();
                String pwCheck = pwCheckEditText.getText().toString();

                if(email.length() == 0 || pw.length() == 0 || pwCheck.length()==0){
                    Toast toast = Toast.makeText(JoinActivity.this, "아이디와 비밀번호는" +
                            "필수 입력사항입니다", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if(!pw.equals(pwCheck)){
                    Toast toast = Toast.makeText(JoinActivity.this, "비밀번호가 일치하지 않습니다",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT email FROM Members WHERE email = '" + email +"'";
                cursor=database.rawQuery(sql, null);

                if(cursor.getCount()!=0){
                    Toast toast = Toast.makeText(JoinActivity.this, "이미 존재하는 계정입니다",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Member member = new Member(email, pw);
                    helper.createMember(member);
                    Toast toast = Toast.makeText(JoinActivity.this, "가입이 완료되었습니다",
                            Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
