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
import com.example.administrator.tmi.data.Board;
import com.example.administrator.tmi.data.ItemData;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Board> boardList;
    private Context context;

    public MyAdapter(Context context, List<Board> boardList){
        this.context = context;
        this.boardList = boardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position){
        final Board board = boardList.get(position);
        viewHolder.nameText.setText(board.getMember().getEmail());
        viewHolder.subjectText.setText(board.getTitle());
        viewHolder.mainText.setText(board.getContent());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainDetailActivity.class);
                intent.putExtra("subject", board.getTitle());
                intent.putExtra("mainText", board.getContent());
                intent.putExtra("email", board.getMember().getEmail());
                context.startActivity(intent);
            }
        } );
    }

    @Override
    public int getItemCount(){return boardList.size();}

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
            dateText = (TextView)itemView.findViewById(R.id.item_date);
            nameText = (TextView)itemView.findViewById(R.id.item_nickname);
            likeImageView = (ImageView)itemView.findViewById(R.id.item_book);
            replyImageView = (ImageView)itemView.findViewById(R.id.item_talk_bub);
            replyCount = (TextView)itemView.findViewById(R.id.item_reply_count);
            subjectText = (TextView)itemView.findViewById(R.id.item_subject);
            mainText = (TextView)itemView.findViewById(R.id.item_text);
            tagsText = (TextView)itemView.findViewById(R.id.item_tags);
        }
    }
}
