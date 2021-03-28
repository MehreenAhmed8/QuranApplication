package com.myproject.alquran;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.myproject.alquran.model.AayaatModel;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class SurahDBAdapter extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "QuranDB";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_AAYAAT = "aayaat";
    public static final String KEY_ARABIC_TEXT = "arabicText";
    public static final String KEY_URDU_TRANSLATION = "urduWithSiratulJinan";
    public static final String KEY_AYAT_NUMBER = "ayatNumber";
    public static final String KEY_SURAH_ID = "surahId";


    public SurahDBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<AayaatModel> getSurahList(int surahId) throws
            SQLException {
        SQLiteDatabase db = getReadableDatabase();
        List<AayaatModel> orderDetailList = new ArrayList<>();
        String queryFromAayaatTable = "SELECT * FROM " + TABLE_AAYAAT + " WHERE surahId=" + surahId + " ORDER BY " + KEY_AYAT_NUMBER + "  ASC";
        Cursor mCursor = db.rawQuery(queryFromAayaatTable, null);
        if (mCursor.moveToFirst()) {
            do {
                AayaatModel surahModel = new AayaatModel();
                surahModel.setAyatNumber(mCursor.getInt(mCursor.getColumnIndexOrThrow(KEY_AYAT_NUMBER)));
                surahModel.setArabicText(mCursor.getString(mCursor.getColumnIndexOrThrow(KEY_ARABIC_TEXT)));
                surahModel.setUrduText(mCursor.getString(mCursor.getColumnIndexOrThrow(KEY_URDU_TRANSLATION)));
                surahModel.setSurahId(mCursor.getInt(mCursor.getColumnIndexOrThrow(KEY_SURAH_ID)));
                orderDetailList.add(surahModel);
            } while (mCursor.moveToNext());
        }
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        return orderDetailList;
    }
}
