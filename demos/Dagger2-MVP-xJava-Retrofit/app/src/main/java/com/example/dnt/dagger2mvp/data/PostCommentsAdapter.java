package com.example.dnt.dagger2mvp.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dnt.dagger2mvp.R;

import java.util.List;

/**
 * Created by dnt on 2.2.2017 г..
 */

public class PostCommentsAdapter  extends RecyclerView.Adapter<PostCommentsAdapter.MyViewHolder>  {

    List<PostComment> mData;
    private LayoutInflater inflater;
    private Context mContext;

    public PostCommentsAdapter(Context context, List<PostComment> data) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.post_comments, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostCommentsAdapter.MyViewHolder holder, int position) {
        String current = mData.get(position).getBody();
        holder.setData(current,position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        String current;
        TextView text;
        View itemView;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.text = (TextView)itemView.findViewById(R.id.post_comment);
        }

        public void setData(String current, int position) {
            this.text.setText(current);
            this.position = position;
            this.current = current;
        }

    }
}
