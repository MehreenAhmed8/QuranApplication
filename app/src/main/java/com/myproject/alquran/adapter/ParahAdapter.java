package com.myproject.alquran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.myproject.alquran.R;
import com.myproject.alquran.holder.ParahHolderRv;
import com.myproject.alquran.model.ParahModel;

import java.util.List;


public class ParahAdapter extends RecyclerView.Adapter<ParahHolderRv> {

    public List<ParahModel> mArrListData;
    private Context mContext;

    public ParahAdapter(Context mContext, List<ParahModel> applications) {
        this.mContext = mContext;
        this.mArrListData = applications;
    }

    @Override
    public ParahHolderRv onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.parah_adapter, parent, false);
        return new ParahHolderRv(mContext, v);
    }

    @Override
    public void onBindViewHolder(ParahHolderRv holder, int i)
    {
        holder.updateView(mArrListData.get(i));
    }

    @Override
    public int getItemCount() {
        return mArrListData == null ? 0 : mArrListData.size();
    }
}