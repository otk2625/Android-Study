package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// 어댑터에게 꼭알려줘야하는것!
// 1. 컬렉션 정보
public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private List<Movie> movies;


    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;

    }


    // 전체 크기를 확인하기 위해서 필요 (나도, 어댑터도)
    @Override
    public int getCount() {
        return movies.size();
    }

    //클릭하거나 어떤 이벤트 발생시에 컬렉션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 객체를 생성해서 그림을 그리는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 부모 컨텍스트 가져오기 (Context <- MainActivity)
        //Context context = parent.getContext();
        MainActivity mainActivityContext = (MainActivity)parent.getContext();
        // 인플레이터 객체 생성 완료 (xml을 자바 객체로 만들게 해주는 도구)
       LayoutInflater inflater = (LayoutInflater)mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_item, parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_subtitle);
        ImageView imgMovie = view.findViewById(R.id.img_movie);

        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getSubTitle());
        imgMovie.setImageResource(movies.get(position).getImgView());

        view.setOnClickListener(view1 -> {
            Toast.makeText(mainActivityContext, "클릭됨 "+position, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
