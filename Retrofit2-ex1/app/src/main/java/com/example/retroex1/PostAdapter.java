package com.example.retroex1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> posts;



    public void setPosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.post_item, parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView userId;
        private TextView title;
        private TextView text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            userId = itemView.findViewById(R.id.userid);
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);
        }

        public void setItem(Post post){
            id.setText(post.getId()+"");
            id.append("추가됨");
            userId.setText(post.getUserId()+"");
            title.setText(post.getTitle());
            text.setText(post.getText());

        }
    }
}
