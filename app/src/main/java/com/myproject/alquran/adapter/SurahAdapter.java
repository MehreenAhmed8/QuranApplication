package com.myproject.alquran.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.myproject.alquran.R;
import com.myproject.alquran.holder.SurahHolderRv;
import com.myproject.alquran.model.AayaatModel;

import java.util.List;



public class SurahAdapter extends RecyclerView.Adapter<SurahHolderRv> {
    public List<AayaatModel> mArrListData;
    private Context mContext;
    private View.OnClickListener onClickListener;

    public SurahAdapter(Context mContext, List<AayaatModel> applications, View.OnClickListener onClickListener) {
        this.mContext = mContext;
        this.mArrListData = applications;
        this.onClickListener = onClickListener;
    }

    @Override
    public SurahHolderRv onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_surah_adapter, parent, false);
        return new SurahHolderRv(mContext, v);
    }

    @Override
    public void onBindViewHolder(SurahHolderRv holder, int i) {
        holder.updateView(mArrListData.get(i), i, onClickListener);
    }

    @Override
    public int getItemCount() {
        return mArrListData == null ? 0 : mArrListData.size();
    }

}
