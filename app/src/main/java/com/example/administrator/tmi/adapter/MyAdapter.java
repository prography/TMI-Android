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

    private List<ItemData> itemList;
    private Context context;

    public MyAdapter(Context context, List<ItemData> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position){
        final ItemData itemData = itemList.get(position);
        viewHolder.dateText.setText(itemData.getDateText());
        viewHolder.nameText.setText(itemData.getNameText());
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
        TextView replyCount;
        TextView subjectText;
        TextView mainText;
        TextView tagsText;

        ViewHolder(View itemView){
            super(itemView);
            dateText = (TextView)itemView.findViewById(R.id.item_date);
            nameText = (TextView)itemView.findViewById(R.id.item_nickname);
            likeImageView = (ImageView)itemView.findViewById(R.id.item_book);
            replyCount = (TextView)itemView.findViewById(R.id.item_reply_count);
            subjectText = (TextView)itemView.findViewById(R.id.item_subject);
            mainText = (TextView)itemView.findViewById(R.id.item_text);
            tagsText = (TextView)itemView.findViewById(R.id.item_tags);
        }
    }
}
