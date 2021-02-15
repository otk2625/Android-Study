package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.MyViewHolder> {
    private String myNickname;
    private List<chatdata> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Textview_nickname;
        public TextView TextView_msg;
        public View rootview;
        public MyViewHolder(View v) {
            super(v);
            Textview_nickname = v.findViewById(R.id.TextView_Title);
            TextView_msg = v.findViewById(R.id.TextView_Content);


        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public chatAdapter(List<chatdata> myDataset, Context context, String myNickname) {
        mDataset = myDataset;
        this.myNickname = myNickname;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public chatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        chatdata chat = mDataset.get(position);
        holder.Textview_nickname.setText(chat.getNickname());
        holder.TextView_msg.setText(chat.getMsg());
        if(chat.getNickname().equals(this.myNickname)){
           // holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);

        }
        else{

        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size() ;
    }
    public chatdata getchat(int position){ return mDataset != null ? mDataset.get(position):null ;}
}