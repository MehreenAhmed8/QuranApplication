package com.myproject.alquran.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myproject.alquran.R;
import com.myproject.alquran.model.ParahModel;

public class ParahHolderRv extends BaseRecyclerViewHolder {
    private TextView tv_bismillah;
    private TextView tv_aayaat;
    private ImageView ivSurahTitle;
    View view1, view2;

    public ParahHolderRv(Context mContext, View itemView) {
        super(mContext, itemView);
    }

    @Override
    protected void initComponents(View view) {
        tv_bismillah = view.findViewById(R.id.tv_bismillah);
        tv_aayaat = view.findViewById(R.id.tv_aayaat);
        ivSurahTitle = view.findViewById(R.id.ivSurahTitle);
        view1 = view.findViewById(R.id.view1);
        view2 = view.findViewById(R.id.view2);
    }


    public void updateView(ParahModel data) {
        if (data.getBismillah() != null && (!TextUtils.isEmpty(data.getBismillah()))) {
            if (data.getSurahNumber() != null) {
                int id = mContext.getResources().getIdentifier("s" + data.getSurahNumber(), "drawable", mContext.getPackageName());
                ivSurahTitle.setImageResource(id);
                ivSurahTitle.setVisibility(View.VISIBLE);
            } else {
                view1.setVisibility(View.GONE);
                ivSurahTitle.setVisibility(View.GONE);
            }
            tv_bismillah.setText(data.getBismillah());
            tv_bismillah.setVisibility(View.VISIBLE);
        } else {
            ivSurahTitle.setVisibility(View.GONE);
            tv_bismillah.setVisibility(View.GONE);
            view1.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
        }
        String surah = "";
        for (int i = 0; i < data.getmArrSurah().size(); i++) {
            surah = surah + data.getmArrSurah().get(i);
        }
        tv_aayaat.setText(surah);
    }
}