package com.example.dnt.dagger2mvp.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dnt.dagger2mvp.R;
import com.example.dnt.dagger2mvp.util.MyCommunicator;

import java.util.List;

/**
 * Created by dnt on 2.2.2017 г..
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    List<Post> mData;
    private LayoutInflater inflater;
    private Context mContext;

    public PostsAdapter(Context context, List<Post> data) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String current = mData.get(position).getTitle();
        holder.setData(current,position);
        holder.setListeners();
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
            this.text = (TextView)itemView.findViewById(R.id.tvTitle);
        }

        public void setData(String current, int position) {
            this.text.setText(current);
            this.position = position;
            this.current = current;
        }

        public void setListeners() {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MyCommunicator myCommunicator = (MyCommunicator) mContext;
                    myCommunicator.displayDetails(position);
                }
            });
        }
    }
}
