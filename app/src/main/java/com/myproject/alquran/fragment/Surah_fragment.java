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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.alquran.R;
import com.myproject.alquran.SurahDBAdapter;
import com.myproject.alquran.adapter.SurahAdapter;
import com.myproject.alquran.model.AayaatModel;
import com.myproject.alquran.utils.AppBundles;

import java.util.ArrayList;
import java.util.List;


public class Surah_fragment extends Fragment implements View.OnClickListener {
    private ImageView mIbBack;
    private Context mContext;
    List<AayaatModel> mArrRamoz = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SurahAdapter mMatalibAdapter;
    private int mSurahPosition;
    private ImageView ivSurahTitle;
    private String surahName;
    private CoordinatorLayout coordinatorLayout;
    private TextView tv_surahNumber;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_surah_fragment, container, false);
        initGuiComponents(view);
        parseBundle();

        new GetDataWithProgress().execute();
        return view;
    }

    private void initGuiComponents(View view)
    {
        mIbBack = view.findViewById(R.id.ib_back);
        mRecyclerView = view.findViewById(R.id.list);
        ivSurahTitle = view.findViewById(R.id.ivSurahTitle);
        coordinatorLayout = view.findViewById(R.id.coordinator);
        tv_surahNumber = view.findViewById(R.id.tv_surahNumber);
        setClickListener();
    }

    private void parseBundle()
    {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            if (bundle.containsKey(AppBundles.SURAH_POSITION.getKey())) {
                surahName = bundle.getString(AppBundles.SURAH_POSITION.getKey());
                int id = mContext.getResources().getIdentifier(surahName, "drawable", mContext.getPackageName());
                ivSurahTitle.setImageResource(id);
                mSurahPosition = Integer.parseInt(surahName.replace("s", ""));
                tv_surahNumber.setText("( " + mSurahPosition);

            }
        }
    }

    private class GetDataWithProgress extends AsyncTask<Void, Void, Void>
    {
        private SurahDBAdapter db;

        @Override
        protected Void doInBackground(Void... params)
        {
            db = new SurahDBAdapter(mContext);
            mArrRamoz = db.getSurahList(mSurahPosition);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            if (mArrRamoz != null) {
                setData();
            }
        }

    }

    private void setData()
    {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mMatalibAdapter = new SurahAdapter(mContext, mArrRamoz, this);
        mRecyclerView.setAdapter(mMatalibAdapter);

    }

    private void closeThisFragment() {
        getActivity().getSupportFragmentManager().popBackStack();
    }


    private void setClickListener()
    {
        mIbBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.ib_back:
                Toast toast = Toast.makeText(mContext,
                        "The Prophet (ﷺ) said, \"The best among you (Muslims) are those who learn the Qur'an and teach it.\"",
                        Toast.LENGTH_LONG);

                toast.show();
                closeThisFragment();
                break;
        }
    }
}
