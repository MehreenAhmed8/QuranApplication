package com.myproject.alquran.holder;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.recyclerview.widget.RecyclerView;


class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
    protected Context mContext;


    public BaseRecyclerViewHolder(Context mContext, View itemView) {
        super(itemView);
        this.mContext = mContext;
        initComponents(itemView);
        addListener();
    }


    protected void initComponents(View view) {
        if ( view != null && mContext == null ) {
            mContext = view.getContext();
        }
    }

    protected void addListener() {
    }

    @Override
    public void onClick(View v) {
    }

}
