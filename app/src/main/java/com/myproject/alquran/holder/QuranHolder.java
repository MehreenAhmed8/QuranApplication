package com.myproject.alquran.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.myproject.alquran.R;

public class QuranHolder extends BaseRecyclerViewHolder {
    private LinearLayout mLlMain;
    private ImageView mIvName;
    private TextView mTvNumber;

    public QuranHolder(Context mContext, View itemView) {
        super(mContext, itemView);
    }

    @Override
    protected void initComponents(View view) {
        mLlMain = view.findViewById(R.id.ll_main);
        mIvName = view.findViewById(R.id.mIvName);
        mTvNumber = view.findViewById(R.id.tv_number);
    }

    public void updateView(String data, int position, View.OnClickListener onClickListener) {
        int id = mContext.getResources().getIdentifier(data, "drawable", mContext.getPackageName());
        mIvName.setImageResource(id);
        mTvNumber.setText("(" + (position + 1));
        mLlMain.setTag(data);
        mLlMain.setOnClickListener(onClickListener);
    }
}