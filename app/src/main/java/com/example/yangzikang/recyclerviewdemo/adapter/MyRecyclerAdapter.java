package com.example.yangzikang.recyclerviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yangzikang.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;



public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ATViewHolder> {

    private List<String>  texts;
    private Context mContext;
    private Button clear;

    List<Integer> selection;
    List<View> viewList;
    boolean isSelect = false;

    public MyRecyclerAdapter(List texts,Button clear, Context context){
        this.texts = texts;
        this.mContext = context;
        this.clear = clear;
        selection = new ArrayList<>();
        viewList = new ArrayList<>();
    }
    @Override
    public MyRecyclerAdapter.ATViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        MyRecyclerAdapter.ATViewHolder viewHolder = new MyRecyclerAdapter.ATViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ATViewHolder holder, int position) {
        String text = texts.get(position);
        holder.text.setText(text);
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }


    public void clearSelectedState(){
        for(View v :viewList){
            TextView t = (TextView)v.findViewById(R.id.recycler_text);
            t.setBackgroundResource(R.color.colorWhite);
        }
        selection.clear();
        viewList.clear();
    }


    class ATViewHolder extends RecyclerView.ViewHolder{
        TextView text;


        public ATViewHolder(final View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.recycler_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean flag = true;
                    if(isSelect){
                        for(int i = 0;i<selection.size();i++){
                            if(selection.get(i)==getPosition()){
                                text.setBackgroundResource(R.color.colorWhite);
                                selection.remove(i);
                                viewList.remove(i);
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            text.setBackgroundResource(R.color.colorAccent);
                            selection.add(getPosition());
                            viewList.add(itemView);
                        }

                    }

                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    isSelect = true;
                    text.setBackgroundResource(R.color.colorAccent);
                    int position = getPosition();
                    selection.add(position);
                    viewList.add(itemView);


                    clear.setVisibility(View.VISIBLE);

                    return isSelect;
                }
            });

        }
    }

}