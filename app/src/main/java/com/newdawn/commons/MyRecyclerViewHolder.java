package com.newdawn.commons;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

     TextView titleTextView;

    public MyRecyclerViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_text_view);
    }
}
