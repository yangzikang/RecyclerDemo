package com.example.yangzikang.recyclerviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yangzikang.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.textColorTertiary;
import static java.lang.System.in;


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ATViewHolder> {

    private List<String>  texts;
    private Context mContext;

    List<Integer> selection;
    boolean isSelect = false;

    public MyRecyclerAdapter(List texts, Context context){
        this.texts = texts;
        this.mContext = context;
        selection = new ArrayList<>();
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
        selection.clear();

    }


    class ATViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        public ATViewHolder(final View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.recycler_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = 0;
                    if(isSelect){
                        for(i = 0;i<selection.size();i++){
                            if(selection.get(i)==getPosition()){
                                text.setBackgroundResource(R.color.colorWhite);
                                break;
                            }
                        }

                        if(i == selection.size()){
                            text.setBackgroundResource(R.color.colorAccent);
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
                    return isSelect;
                }
            });

        }
    }

}