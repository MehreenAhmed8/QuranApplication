package com.myproject.alquran.model;

import java.util.ArrayList;
import java.util.List;

public class ParahModel {
    private String bismillah;
    private List<String> mArrSurah;
    private Integer surahNumber;

    public String getBismillah() {
        return bismillah;
    }

    public void setBismillah(String bismillah) {
        this.bismillah = bismillah;
    }

    public List<String> getmArrSurah() {
        if (mArrSurah == null) mArrSurah = new ArrayList<>();
        return mArrSurah;
    }

    public void setmArrSurah(List<String> mArrSurah) {
        this.mArrSurah = mArrSurah;
    }

    public Integer getSurahNumber() {
        return surahNumber;
    }

    public void setSurahNumber(Integer surahNumber) {
        this.surahNumber = surahNumber;
    }
}
