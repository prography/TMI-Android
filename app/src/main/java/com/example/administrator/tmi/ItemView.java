package com.example.administrator.tmi;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemView extends FrameLayout {
    public ItemView(Context context){
        super(context);
        init();
    }
    public ItemView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }

    ImageView reply_image, like_image;
    TextView nickname, date_text, subject, main_text, tags, reply_count;
    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.item_layout,this);
        reply_image=(ImageView)findViewById(R.id.reply_image);
        like_image=(ImageView)findViewById(R.id.like_image);
        nickname=(TextView)findViewById(R.id.nickname);
        date_text=(TextView)findViewById(R.id.date_text);
        subject=(TextView)findViewById(R.id.subject);
        main_text=(TextView)findViewById(R.id.main_text);
        tags=(TextView)findViewById(R.id.tags);
        reply_count=(TextView)findViewById(R.id.reply_count);
    }

    ItemData mData;
    public void setItemData(ItemData data){
        mData = data;
        reply_image.setImageResource(data.replyImageId);
        like_image.setImageResource(data.likeImageId);
        nickname.setText(data.nameText);
        date_text.setText(data.dateText);
        subject.setText(data.subjectText);
        main_text.setText(data.mainText);
        tags.setText(data.tagsText);
        reply_count.setText(Integer.toString(data.replyCount));
    }
}
