package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.tmi.DatabaseHelper;
import com.example.administrator.tmi.R;
import com.example.administrator.tmi.data.Member;

import java.io.File;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper helper;
    SQLiteDatabase database;
    public static String emailSave;

    EditText emailEditText;
    EditText pwEditText;
    Button joinButton;
    Button loginButton;

    String sql;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText)findViewById(R.id.login_id);
        pwEditText = (EditText)findViewById(R.id.login_password);

        final DatabaseHelper helper = new DatabaseHelper(this);
        database = helper.getWritableDatabase();

        joinButton = (Button)findViewById(R.id.login_join);
        loginButton = (Button) findViewById(R.id.login_login);


        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String pw = pwEditText.getText().toString();

                if(email.length() ==0||pw.length()==0){
                    Toast toast = Toast.makeText(LoginActivity.this, "아이디와 비밀번호는" +
                            " 필수 입력사항입니다", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT email FROM Members WHERE email = '" + email + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount()!=1){
                    Toast toast = Toast.makeText(LoginActivity.this, "존재하지" +
                            " 않는 아이디입니다", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT password FROM Members WHERE password = '" + pw + "'";
                cursor=database.rawQuery(sql,null);

                cursor.moveToNext();
                if(!pw.equals(cursor.getString(0))){
                    Toast toast = Toast.makeText(LoginActivity.this, "비밀번호가 " +
                            "틀렸습니다", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    emailSave = email;
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                cursor.close();
            }
        });
    }

}
