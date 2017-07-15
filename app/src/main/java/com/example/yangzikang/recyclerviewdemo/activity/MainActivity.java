package com.example.yangzikang.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yangzikang.recyclerviewdemo.R;
import com.example.yangzikang.recyclerviewdemo.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initControl();

    }

    private void initView(){
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.demo_recycler);
    }

    private void initControl(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        List list = new ArrayList();
        for(int i=0;i<15;i++){
            list.add("hello world"+i);
        }
        mRecyclerView.setAdapter(new MyRecyclerAdapter(list, this));
    }
}
