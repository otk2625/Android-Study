package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

        Log.d(TAG, "getView: "+ position);
        if(convertView == null){
            Log.d(TAG, "convertView가 null입니다 ");
        }else
            Log.d(TAG, "convertView가 null이 아닙니다");

        // 부모 컨텍스트 가져오기 (Context <- MainActivity)
        //Context context = parent.getContext();
        MainActivity mainActivityContext = (MainActivity)parent.getContext();
        // 인플레이터 객체 생성 완료 (xml을 자바 객체로 만들게 해주는 도구)
       LayoutInflater inflater = (LayoutInflater)mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 더 쉽게하는 방법!!
       //LayoutInflater inflater1 = LayoutInflater.from(context);

        // 강제성이 없어서!
        //새로 만들어서 계속 만들어주고있다
        View view = inflater.inflate(R.layout.list_item, parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_subtitle);

        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getSubTitle());

        view.setOnClickListener(view1 -> {
           // Toast.makeText(context, "클릭됨 "+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mainActivityContext, DetailActivity.class);
            intent.putExtra("title",movies.get(position).getTitle());
            mainActivityContext.startActivity(intent);
        });

        view.setOnLongClickListener(view1 -> {
            movies.remove(position);
            Toast.makeText(mainActivityContext, "롱클릭됨 "+position, Toast.LENGTH_SHORT).show();
            this.notifyDataSetChanged(); // 데이터 변경후 UI동기화시 호출해야함
            return true;
        });

        return view;
    }
}
