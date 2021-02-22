package com.example.sharedpreparence;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 익명 클래스 내부에서는 외부에 변수(스택)를 접근할 수는 있는데 변경할 수 없다
// 전역변수로 만들면 다 해결된다.
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private final List<Movie> movies;
    private float saveRating = 0;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.movie_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.img_movie);

            imgMovie.setOnClickListener(v -> {
                View dialog = v.inflate(v.getContext(), R.layout.dialog_item, null);
                ImageView ivitem = dialog.findViewById(R.id.iv_item);
                int pos = getAdapterPosition();
                ivitem.setImageResource(movies.get(pos).getImage());
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());

                //추가
                // 이미 pref영역이 있으면 들고오고 없으면 만든다
                SharedPreferences pref = v.getContext().getSharedPreferences("pref",MainActivity.MODE_PRIVATE); //MainActivity에서만 쓸 수 있도록

                RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);
                TextView tvRating = dialog.findViewById(R.id.rating);
                ratingBar.setRating(pref.getFloat("rating"+pos,0));
                tvRating.setText(pref.getFloat("rating"+pos,0)+"");

                ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, b) -> {
                    tvRating.setText(rating+"");
                    saveRating = rating;
                });

                dlg.setTitle("큰 포스터");
                dlg.setView(dialog);
                dlg.setNegativeButton("닫기", null);
                dlg.setPositiveButton("확인",(dialogInterface, i) -> {
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putFloat("rating" + pos ,saveRating);
                    ed.commit();
                });
                dlg.show();
            });
        }

        public void setItem(Movie movie){
            imgMovie.setImageResource(movie.getImage());
        }
    }

}
