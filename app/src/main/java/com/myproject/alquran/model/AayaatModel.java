package com.myproject.alquran.model;

public class AayaatModel {
    private String arabicText;
    private String urduText;
    private int ayatNumber;
    private int surahId;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public String getArabicText() {
        return arabicText;
    }

    public void setArabicText(String arabicText) {
        this.arabicText = arabicText;
    }

    public String getUrduText() {
        return urduText;
    }

    public void setUrduText(String urduText) {
        this.urduText = urduText;
    }

    public int getAyatNumber() {
        return ayatNumber;
    }

    public void setAyatNumber(int ayatNumber) {
        this.ayatNumber = ayatNumber;
    }

    public int getSurahId() {
        return surahId;
    }

    public void setSurahId(int surahId) {
        this.surahId = surahId;
    }
}
