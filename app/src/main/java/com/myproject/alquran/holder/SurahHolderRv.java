package com.myproject.alquran.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myproject.alquran.R;
import com.myproject.alquran.model.AayaatModel;

public class SurahHolderRv extends BaseRecyclerViewHolder {
    private TextView mTvArabic;
    private TextView mTvUrdu;
    private LinearLayout ll_main;


    public SurahHolderRv(Context mContext, View itemView) {
        super(mContext, itemView);
    }

    @Override
    protected void initComponents(View view) {
        mTvArabic = view.findViewById(R.id.tv_arabic);
        mTvUrdu = view.findViewById(R.id.tv_urdu);
        ll_main = view.findViewById(R.id.ll_main);

    }


    public void updateView(AayaatModel data, int position, View.OnClickListener onClickListener) {
        ll_main.setSelected(data.isSelected());
        mTvArabic.setText(data.getArabicText());
        if (!TextUtils.isEmpty(data.getUrduText())) {
            mTvUrdu.setText(data.getUrduText());
            mTvUrdu.setVisibility(View.VISIBLE);
        } else {
            mTvUrdu.setVisibility(View.GONE);
        }


    }
}
