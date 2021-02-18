package com.example.myapplication2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 3. 상속받기
public class NoteAdapter extends  RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private static final String TAG = "NoteAdapter";

    // 4. 컬렉션 생성
    private final List<Note> notes;

    public NoteAdapter(List<Note> notes){
        this.notes = notes;
    }

    // 5. addItem, removeItem
    public  void addItem(Note note){
        notes.add(note);
        notifyDataSetChanged();
    }
    public  void removeItem(int position){
        notes.remove(position);
        notifyDataSetChanged();
    }

    // 7. getView랑 똑같음
    // 차이점이 있다면 listView는 화면에 3개가 필요하면 최초 로딩시에 3개를 그려야하니까 getView가 3번 호출됨
    // 그 다음에 스크롤을 하면 2개가 추가되어야 될때, 다시 getView를 호출
    // 하지만 recyclerView는 스크롤을 해서 2개가 추가되어야 될때 onBindViewHolder를 호출함
    // onCreateViewHolder는 해당 Activity 실행시에만 호출 됨

    @NonNull
    @Override
    // 최초 로딩시 호출
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: 실행됨");
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.note_item, parent,false);
        view.setOnClickListener(view1 -> {
            Log.d(TAG, "onCreateViewHolder: 클릭됨");
        });
        return new MyViewHolder(view); // 이때 view가 리스트뷰에 하나 그려짐!!
    }

    // 스크롤시 데이터만 체인지
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: 실행됨");
        holder.setItem(notes.get(position));
    }

    // 6. 컬렉션 크기 알려주기 (화면에 몇개 그려야 될지를 알아야하기 때문)
    @Override
    public int getItemCount() {
        return notes.size();
    }

    // 1. ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        // 2번 user_item이 가지고 있는 위젯들을 선언

        private TextView tvTitle;
        private TextView tvSubTitle;
        private TextView tvMin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubTitle = itemView.findViewById(R.id.tv_sub_title);
            tvMin = itemView.findViewById(R.id.tv_min);

            itemView.setOnClickListener(view -> {
                Log.d(TAG, "MyViewHolder: " + getAdapterPosition());
                //removeItem(getAdapterPosition());
                addItem(new Note(12,"이건 추가됨","서브타이틀",45));
            });
        }

        public void setItem(Note note){

            tvTitle.setText(note.getTitle());
            tvSubTitle.setText(note.getSubTitle());
            tvMin.setText(note.getMin().toString());
        }
    }
}
