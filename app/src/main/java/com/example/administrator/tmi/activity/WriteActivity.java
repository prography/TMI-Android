package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.tmi.DatabaseHelper;
import com.example.administrator.tmi.R;
import com.example.administrator.tmi.data.Board;
import com.example.administrator.tmi.data.Member;

import static com.example.administrator.tmi.activity.LoginActivity.emailSave;

public class WriteActivity extends AppCompatActivity {
    DatabaseHelper helper;
    SQLiteDatabase database;

    ImageButton backBtn;
    Button writeBtn;
    EditText titleWriteText;
    EditText contextWriteText;

    String sql;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        writeBtn = (Button)findViewById(R.id.button_upload);
        titleWriteText = (EditText)findViewById(R.id.editText);
        contextWriteText = (EditText)findViewById(R.id.editText2);
        backBtn = (ImageButton)findViewById(R.id.search_back_button);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        helper = new DatabaseHelper(WriteActivity.this);
        database = helper.getWritableDatabase();

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleWriteText.getText().toString();
                String context = contextWriteText.getText().toString();
                Board board = new Board();
                Member member = new Member();

                if(title.length() == 0 || context.length() == 0){
                    Toast toast = Toast.makeText(WriteActivity.this, "제목과 본문은" +
                            " 필수 입력사항입니다", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                cursor = database.rawQuery("SELECT * FROM Members WHERE email = '" + emailSave + "'", null);

                cursor.moveToFirst();
                member.setId(cursor.getInt(0));
                member.setEmail(cursor.getString(1));
                member.setPassword(cursor.getString(2));

                board.setMember(member);
                board.setTitle(title);
                board.setContent(context);
                board.setUser_id(member.getId());

                helper.createBoard(board);
                Toast toast = Toast.makeText(WriteActivity.this, "글이 작성되었습니다",
                        Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
