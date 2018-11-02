package com.example.administrator.tmi.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.tmi.DatabaseHelper;
import com.example.administrator.tmi.R;
import com.example.administrator.tmi.adapter.MyAdapter;
import com.example.administrator.tmi.data.Board;
import com.example.administrator.tmi.data.ItemData;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView searchContainerView;
    private MyAdapter searchAdapter;
    DatabaseHelper helper;
    SQLiteDatabase database;
    EditText searchText;
    private List<Board> searchList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchText = (EditText) findViewById(R.id.search_text);
        ImageButton backButton = (ImageButton)findViewById(R.id.search_back_button);
        final ImageButton searchButton = (ImageButton)findViewById(R.id.search_button);
        final ImageView searchImage = (ImageView)findViewById(R.id.search_image);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        searchContainerView = (RecyclerView)findViewById(R.id.search_recycler_container);

        helper = new DatabaseHelper(SearchActivity.this);
        database = helper.getWritableDatabase();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchText.getText().toString();

                if(search.length()==0){
                    Toast toast = Toast.makeText(SearchActivity.this, "검색어를" +
                            "한 글자 이상 입력해주세요", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                searchList = helper.searchBoards(search);

                searchAdapter = new MyAdapter(searchButton.getContext(), searchList);
                RecyclerView.LayoutManager manager =
                        new LinearLayoutManager(searchButton.getContext(),LinearLayoutManager.VERTICAL,false);
                searchContainerView.setLayoutManager(manager);
                searchContainerView.setAdapter(searchAdapter);

                searchImage.setVisibility(View.INVISIBLE);
            }
        });
    }
}
