package com.example.myapplication2.helper;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.PersonActivity;
import com.example.myapplication2.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {
    private static final String TAG = "NavigationViewHelper";

    public static void enable(Context context, NavigationView view){ //어디서 호출하던지 동작하게 함!
        view.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if(id == R.id.item1){
                Toast.makeText(context, "item1클릭됨", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id == R.id.item2){
                Toast.makeText(context, "item2클릭됨", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, PersonActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id == R.id.item3){
                Toast.makeText(context, "item3클릭됨", Toast.LENGTH_SHORT).show();
            }

            return true;
        });
    }
}
