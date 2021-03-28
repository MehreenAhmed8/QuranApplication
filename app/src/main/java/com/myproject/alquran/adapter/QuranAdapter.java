package com.myproject.alquran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.myproject.alquran.R;
import com.myproject.alquran.holder.QuranHolder;

import java.util.ArrayList;
import java.util.List;

public class QuranAdapter extends RecyclerView.Adapter<QuranHolder>
{

    public List<String> mArrListData;
    private Context mContext;
    private View.OnClickListener onClickListener;

    public QuranAdapter(Context mContext, View.OnClickListener onClickListener, List<String> applications) {
        this.mContext = mContext;
        this.mArrListData = applications;
        this.onClickListener=onClickListener;
    }

    @Override
    public QuranHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.parah, parent, false);
        return new QuranHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(QuranHolder holder, int i)
    {
        holder.updateView(mArrListData.get(i), i,onClickListener);

    }
    @Override
    public int getItemCount() {
        return mArrListData == null ? 0 : mArrListData.size();
    }

    public void setData(List<String> mArrMutalibeQuranFiltered)
    {
        if (this.mArrListData != null) {
            this.mArrListData = new ArrayList<>();
            this.mArrListData = mArrMutalibeQuranFiltered;
        }
        notifyDataSetChanged();
    }
}