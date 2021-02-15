package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class news<Public> extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset = {"1","2"};
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        queue = Volley.newRequestQueue(this);
        getnews();
    }

    public  void getnews(){
        // Instantiate the RequestQueue.

        String url ="http://newsapi.org/v2/top-headlines?country=kr&apiKey=45dd0d5261694330a35d67f8b8eabcd6";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.d("NEWS", response);
                        try {

                            JSONObject jsonob = new JSONObject(response);
                            JSONArray jsonArrayarticles = jsonob.getJSONArray("articles");
                            List<newsdata> news = new ArrayList<>();
                            for(int i = 0, j = jsonArrayarticles.length(); i < j; i++){
                                JSONObject obj = jsonArrayarticles.getJSONObject(i);
                                Log.d("NEWS", obj.toString());
                                newsdata newsdata = new newsdata();
                                newsdata.setTitle(obj.getString("title"));
                                newsdata.setContent(obj.getString("description"));
                                newsdata.setUrlToImage(obj.getString("urlToImage"));
                                news.add(newsdata);


                            }
                            // specify an adapter (see also next example)



                            mAdapter = new MyAdapter(news, com.example.myapplication.news.this);
                            recyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}
