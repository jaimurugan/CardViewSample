package com.mallow.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<News> newsList;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initPersonData();
        adapter = new RecyclerViewAdapter(newsList, MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initPersonData() {
        newsList = new ArrayList<>();
        newsList.add(new News(getString(R.string.news_one_title),
                getString(R.string.news_one_desc), R.drawable.image1));
         newsList.add(new News(getString(R.string.news_one_title),
               getString(R.string.news_one_desc), R.drawable.image2));
        newsList.add(new News(getString(R.string.news_one_title),
                getString(R.string.news_one_desc), R.drawable.image3));
        newsList.add(new News(getString(R.string.news_one_title),
                getString(R.string.news_one_desc), R.drawable.image4));
    }
}
