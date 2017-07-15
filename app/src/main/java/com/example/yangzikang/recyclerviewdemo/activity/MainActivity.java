package com.example.yangzikang.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.yangzikang.recyclerviewdemo.R;
import com.example.yangzikang.recyclerviewdemo.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initControl();

    }

    private void initView(){
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.demo_recycler);
        clear = (Button)findViewById(R.id.recycler_clear);
    }

    private void initControl(){
        List list = new ArrayList();
        for(int i=0;i<15;i++){
            list.add("hello world"+i);
        }

        final MyRecyclerAdapter adapter = new MyRecyclerAdapter(list,clear,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);


        mRecyclerView.setAdapter(adapter);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clearSelectedState();
                clear.setVisibility(View.INVISIBLE);
            }
        });

    }
}
