package com.newdawn.commons;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    ArrayList arrayList;
    LayoutInflater inflater;

    public MyRecyclerViewAdapter(Context context) {
        arrayList = new ArrayList();
        inflater = LayoutInflater.from(context);
    }

    public void  addItem(String string){
        arrayList.add(string);
        notifyDataSetChanged();
    }
    public void removeItem(){

    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_view,parent,false);
        String string = (String) view.getTag();
        TextView textView = view.findViewById(R.id.title_text_view);
        textView.setText(string);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        String string = (String) arrayList.get(position);
        holder.titleTextView.setText(string);
        holder.titleTextView.setTag(string);

        if(position%2==0){
            holder.titleTextView.setBackgroundColor(Color.parseColor("#22000000"));
        }else {
            holder.titleTextView.setBackground(null);
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}



