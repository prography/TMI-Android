package com.example.administrator.tmi.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.tmi.R;
import com.example.administrator.tmi.adapter.MyAdapter;
import com.example.administrator.tmi.data.ItemData;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.INVISIBLE;

public class SearchActivity extends AppCompatActivity {
    RecyclerView searchContainerView;
    private MyAdapter searchAdapter;
    private List<ItemData> searchList = new ArrayList<>();
    TextView countText;
    EditText searchText;
    ImageButton searchButton;
    ImageButton backButton;
    LinearLayout searchBar;
    LinearLayout searchResult;
    ImageView searchImage;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchImage = (ImageView)findViewById(R.id.search_image);
        searchResult = (LinearLayout)findViewById(R.id.search_result);
        searchBar = (LinearLayout)findViewById(R.id.search_bar);
        searchContainerView = (RecyclerView)findViewById(R.id.search_recycler_container);
        countText = (TextView)findViewById(R.id.search_count);
        searchText = (EditText)findViewById(R.id.search_text);
        searchButton = (ImageButton)findViewById(R.id.search_button);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        backButton = (ImageButton)findViewById(R.id.search_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        searchButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                searchBar.setBackgroundResource(R.drawable.search_back_bar01);
                searchResult.setVisibility(View.VISIBLE);
                searchImage.setVisibility(INVISIBLE);

                countText.setText(searchText.getText());


                return false;
            }
        });

    }
}
