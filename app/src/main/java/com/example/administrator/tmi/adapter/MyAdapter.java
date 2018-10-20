package com.example.administrator.tmi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tmi.R;
import com.example.administrator.tmi.activity.MainDetailActivity;
import com.example.administrator.tmi.data.ItemData;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    static List<ItemData> itemList;
    static Context context;

    public MyAdapter(Context context, List<ItemData> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position){
        final ItemData itemData = itemList.get(position);
        viewHolder.dateText.setText(itemData.getDateText());
        viewHolder.nameText.setText(itemData.getNameText());
        viewHolder.likeImageView.setImageResource(itemData.getLikeImageId());
        viewHolder.replyImageView.setImageResource(itemData.getReplyImageId());
        viewHolder.replyCount.setText(String.valueOf(itemData.getReplyCount()));
        viewHolder.subjectText.setText(itemData.getSubjectText());
        viewHolder.mainText.setText(itemData.getMainText());
        viewHolder.tagsText.setText(itemData.getTagsText());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainDetailActivity.class);
                intent.putExtra("subject", itemData.getSubjectText());
                intent.putExtra("mainText", itemData.getMainText());
                intent.putExtra("nickname", itemData.getNameText());
                intent.putExtra("date", itemData.getDateText());
                intent.putExtra("tags",itemData.getTagsText());
                context.startActivity(intent);
            }
        } );
    }

    @Override
    public int getItemCount(){return itemList.size();}

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateText;
        TextView nameText;
        ImageView likeImageView;
        ImageView replyImageView;
        TextView replyCount;
        TextView subjectText;
        TextView mainText;
        TextView tagsText;

        ViewHolder(View itemView){
            super(itemView);
            dateText = (TextView)itemView.findViewById(R.id.date_text);
            nameText = (TextView)itemView.findViewById(R.id.nickname);
            likeImageView = (ImageView)itemView.findViewById(R.id.like_image);
            replyImageView = (ImageView)itemView.findViewById(R.id.reply_image);
            replyCount = (TextView)itemView.findViewById(R.id.reply_count);
            subjectText = (TextView)itemView.findViewById(R.id.subject);
            mainText = (TextView)itemView.findViewById(R.id.main_text);
            tagsText = (TextView)itemView.findViewById(R.id.tags);
        }
    }
}
