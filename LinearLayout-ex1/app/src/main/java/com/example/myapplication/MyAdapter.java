package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<newsdata> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_Title;
        public TextView TextView_Content;
        public SimpleDraweeView ImageView_Title;
        public MyViewHolder(View v) {
            super(v);
            TextView_Title = v.findViewById(R.id.TextView_Title);
            TextView_Content = v.findViewById(R.id.TextView_Content);
            ImageView_Title = (SimpleDraweeView)v.findViewById(R.id.ImageView_Title);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<newsdata> myDataset, Context context) {
        mDataset = myDataset;
        Fresco.initialize(context); //초기화
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_news, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        newsdata news = mDataset.get(position);
        holder.TextView_Title.setText(news.getTitle());
        holder.TextView_Content.setText(news.getContent());
        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");

        holder.ImageView_Title.setImageURI(uri);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size() ;
    }
}