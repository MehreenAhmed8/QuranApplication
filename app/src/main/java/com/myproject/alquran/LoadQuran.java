package com.myproject.alquran;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.alquran.adapter.QuranAdapter;
import com.myproject.alquran.fragment.ParahFragment;
import com.myproject.alquran.fragment.Surah_fragment;
import com.myproject.alquran.utils.AppBundles;
import com.myproject.alquran.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class LoadQuran extends AppCompatActivity implements View.OnClickListener
{

    private RecyclerView mRecyclerView;
    private TextView tvParah, tvSurah;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_quran);
        initGUIComponents();
        addClickListener();
        setData();

    }
    private void initGUIComponents() {
        mRecyclerView = findViewById(R.id.list);

        tvParah = findViewById(R.id.tvParah);
        tvSurah = findViewById(R.id.tvSurah);
        tvSurah.setSelected(true);
        tvParah.setSelected(false);
    }
    private void addClickListener() {
        tvSurah.setOnClickListener(this);
        tvParah.setOnClickListener(this);
    }

    private QuranAdapter mQuranAdapter;

    private void setData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(LoadQuran.this, LinearLayoutManager.VERTICAL, false));
        mQuranAdapter = new QuranAdapter(LoadQuran.this, this, getSurahist());
        mRecyclerView.setAdapter(mQuranAdapter);
    }
    private List<String> getParaList() {
        List<String> paraList = new ArrayList<>();
        paraList.add("p1");
        paraList.add("p2");
        paraList.add("p3");
        paraList.add("p4");
        paraList.add("p5");
        paraList.add("p6");
        paraList.add("p7");
        paraList.add("p8");
        paraList.add("p9");
        paraList.add("p10");
        paraList.add("p11");
        paraList.add("p12");
        paraList.add("p13");
        paraList.add("p14");
        paraList.add("p15");
        paraList.add("p16");
        paraList.add("p17");
        paraList.add("p18");
        paraList.add("p19");
        paraList.add("p20");
        paraList.add("p21");
        paraList.add("p22");
        paraList.add("p23");
        paraList.add("p24");
        paraList.add("p25");
        paraList.add("p26");
        paraList.add("p27");
        paraList.add("p28");
        paraList.add("p29");
        paraList.add("p30");
        return paraList;
    }

    private List<String> getSurahist() {
        List<String> surahList = new ArrayList<>();
        surahList.add("s1");
        surahList.add("s2");
        surahList.add("s3");
        surahList.add("s4");
        surahList.add("s5");
        surahList.add("s6");
        surahList.add("s7");
        surahList.add("s8");
        surahList.add("s9");
        surahList.add("s10");
        surahList.add("s11");
        surahList.add("s12");
        surahList.add("s13");
        surahList.add("s14");
        surahList.add("s15");
        surahList.add("s16");
        surahList.add("s17");
        surahList.add("s18");
        surahList.add("s19");
        surahList.add("s20");
        surahList.add("s21");
        surahList.add("s22");
        surahList.add("s23");
        surahList.add("s24");
        surahList.add("s25");
        surahList.add("s26");
        surahList.add("s27");
        surahList.add("s28");
        surahList.add("s29");
        surahList.add("s30");
        surahList.add("s31");
        surahList.add("s32");
        surahList.add("s33");
        surahList.add("s34");
        surahList.add("s35");
        surahList.add("s36");
        surahList.add("s37");
        surahList.add("s38");
        surahList.add("s39");
        surahList.add("s40");
        surahList.add("s41");
        surahList.add("s42");
        surahList.add("s43");
        surahList.add("s44");
        surahList.add("s45");
        surahList.add("s46");
        surahList.add("s47");
        surahList.add("s48");
        surahList.add("s49");
        surahList.add("s50");
        surahList.add("s51");
        surahList.add("s52");
        surahList.add("s53");
        surahList.add("s54");
        surahList.add("s55");
        surahList.add("s56");
        surahList.add("s57");
        surahList.add("s58");
        surahList.add("s59");
        surahList.add("s60");
        surahList.add("s61");
        surahList.add("s62");
        surahList.add("s63");
        surahList.add("s64");
        surahList.add("s65");
        surahList.add("s66");
        surahList.add("s67");
        surahList.add("s68");
        surahList.add("s69");
        surahList.add("s70");
        surahList.add("s71");
        surahList.add("s72");
        surahList.add("s73");
        surahList.add("s74");
        surahList.add("s75");
        surahList.add("s76");
        surahList.add("s77");
        surahList.add("s78");
        surahList.add("s79");
        surahList.add("s80");
        surahList.add("s81");
        surahList.add("s82");
        surahList.add("s83");
        surahList.add("s84");
        surahList.add("s85");
        surahList.add("s86");
        surahList.add("s87");
        surahList.add("s88");
        surahList.add("s89");
        surahList.add("s90");
        surahList.add("s91");
        surahList.add("s92");
        surahList.add("s93");
        surahList.add("s94");
        surahList.add("s95");
        surahList.add("s96");
        surahList.add("s97");
        surahList.add("s98");
        surahList.add("s99");
        surahList.add("s100");
        surahList.add("s101");
        surahList.add("s102");
        surahList.add("s103");
        surahList.add("s104");
        surahList.add("s105");
        surahList.add("s106");
        surahList.add("s107");
        surahList.add("s108");
        surahList.add("s109");
        surahList.add("s110");
        surahList.add("s111");
        surahList.add("s112");
        surahList.add("s113");
        surahList.add("s114");
        return surahList;
    }

    private void openSurahPageFragment(String name) {
          Bundle bundle = new Bundle();
          bundle.putString(AppBundles.SURAH_POSITION.getKey(), name);
          Fragment fragment = new Surah_fragment();
          fragment.setArguments(bundle);
          if (fragment != null) {
              FragmentManager fragmentManager = getSupportFragmentManager();
              fragmentManager
                     .beginTransaction()
                    .replace(R.id.your_place_holder, fragment,
                            AppConstants.FragmentTags.TAG_FRAGMENT_SURAH)
                      .addToBackStack(AppConstants.FragmentTags.TAG_FRAGMENT_SURAH)
                    .commit();
        }
    }
    private void openParahPageFragment(String name) {
          Bundle bundle = new Bundle();
          bundle.putString(AppBundles.PARAH_POSITION.getKey(), name);
          Fragment fragment = new ParahFragment();
          fragment.setArguments(bundle);
          if (fragment != null)
          {
              FragmentManager fragmentManager = getSupportFragmentManager();
              fragmentManager
                    .beginTransaction()
                    .replace(R.id.your_place_holder, fragment,
                            AppConstants.FragmentTags.TAG_FRAGMENT_PARAH)
                    .addToBackStack(AppConstants.FragmentTags.TAG_FRAGMENT_PARAH)
                      .commit();
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvParah:
                if (!v.isSelected()) {
                    mQuranAdapter.setData(getParaList());
                     tvParah.setSelected(true);
                    tvSurah.setSelected(false);
                }
                break;
            case R.id.tvSurah:
                if (!v.isSelected())
                {
                    mQuranAdapter.setData(getSurahist());
                    tvSurah.setSelected(true);
                    tvParah.setSelected(false);
                }
                break;
            case R.id.ll_main:
                String name = (String) v.getTag();
                if (name.contains("s")) {
                    openSurahPageFragment(name);
                } else
                    {
                    openParahPageFragment(name);
                }
                break;
        }
    }
}