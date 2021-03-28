package com.myproject.alquran.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.alquran.ParahDBAdapter;
import com.myproject.alquran.R;
import com.myproject.alquran.adapter.ParahAdapter;
import com.myproject.alquran.model.AayaatModel;
import com.myproject.alquran.model.ParahModel;
import com.myproject.alquran.utils.AppBundles;

import java.util.ArrayList;
import java.util.List;

public class ParahFragment extends Fragment implements View.OnClickListener {
    private ImageView mIbBack;
    private Context mContext;
    List<ParahModel> mArrRamoz = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ParahAdapter mMatalibAdapter;
    private int mParahPosition;
    private ImageView ivParahTitle;
    private String parahName;
    private TextView tv_parahNumber;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parah_fragment, container, false);
        initGuiComponents(view);
        parseBundle();
        new GetDataWithProgress().execute();
        return view;
    }

    private void initGuiComponents(View view) {
        mIbBack = view.findViewById(R.id.iv_back);
        mRecyclerView = view.findViewById(R.id.list);
        tv_parahNumber = view.findViewById(R.id.tv_parahNumber);
        ivParahTitle = view.findViewById(R.id.ivParahTitle);
        setClickListener();
    }


    private void parseBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            if (bundle.containsKey(AppBundles.PARAH_POSITION.getKey())) {
                parahName = bundle.getString(AppBundles.PARAH_POSITION.getKey());
                int id = mContext.getResources().getIdentifier(parahName, "drawable", mContext.getPackageName());
                ivParahTitle.setImageResource(id);
                mParahPosition = Integer.parseInt(parahName.replace("p", ""));
                tv_parahNumber.setText("( " + mParahPosition);
            }
        }
    }

    private class GetDataWithProgress extends AsyncTask<Void, Void, Void> {
        private ParahDBAdapter db;


        @Override
        protected Void doInBackground(Void... params) {
            db = new ParahDBAdapter(mContext);
            List<AayaatModel> mArrAayaat = new ArrayList<>();
            mArrAayaat.addAll(db.getParahList(mParahPosition));
            int currentSurahNumber = 0;
            ParahModel parahModel = null;
            for (int i = 0; i < mArrAayaat.size(); i++) {
                if (currentSurahNumber != mArrAayaat.get(i).getSurahId()) {
                    currentSurahNumber = mArrAayaat.get(i).getSurahId();
                    parahModel = new ParahModel();
                    parahModel.setSurahNumber(mArrAayaat.get(i).getSurahId());
                    mArrRamoz.add(parahModel);
                }
                if (mArrAayaat.get(i).getAyatNumber() == 0) {
                    parahModel.setBismillah(mArrAayaat.get(i).getArabicText());
                } else {
                    parahModel.getmArrSurah().add(mArrAayaat.get(i).getArabicText());
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (mArrRamoz != null) {
                setData();
            }
        }

    }

    private void setData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mMatalibAdapter = new ParahAdapter(mContext, mArrRamoz);
        mRecyclerView.setAdapter(mMatalibAdapter);
    }

    private void closeThisFragment() {
        getActivity().getSupportFragmentManager().popBackStack();
    }


    private void setClickListener() {
        mIbBack.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                Toast toast = Toast.makeText(mContext,
                        "The Prophet (ﷺ) said, \"The best among you (Muslims) are those who learn the Qur'an and teach it.\"",
                        Toast.LENGTH_LONG);

                toast.show();
                closeThisFragment();
                break;

        }
    }
}
