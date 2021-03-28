/**
 *
 */

package com.myproject.alquran.utils;

public enum AppBundles {

    SURAH_POSITION("surah_position"),
    PARAH_POSITION("parah_position");

    private String _message_key = "";

    AppBundles(String action) {
        this._message_key = action;
    }

    public String getKey() {
        return this._message_key;
    }
}
