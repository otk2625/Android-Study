package com.example.myapplication4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private static final String TAG = "ChatAdapter";

    // 4. 컬렉션 생성
    private final List<Chatting> chattings;

    public ChatAdapter(List<Chatting> chattings) {
        this.chattings = chattings;
    }

    // 5. addItem, removeItem
    public  void addItem(Chatting chatting){
        chattings.add(chatting);
        notifyDataSetChanged();
    }
    public  void removeItem(int position){
        chattings.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chat_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setItem(chattings.get(position));

    }

    @Override
    public int getItemCount() {
        return chattings.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername;
        private TextView tvContent;
        private TextView tvTimeSet;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tv_username);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTimeSet = itemView.findViewById(R.id.tv_timeset);
        }
        public void setItem(Chatting chat){
            tvUsername.setText(chat.getUsername());
            tvContent.setText(chat.getContent());
            tvTimeSet.setText(chat.getTimeSet());
        }
    }
}
