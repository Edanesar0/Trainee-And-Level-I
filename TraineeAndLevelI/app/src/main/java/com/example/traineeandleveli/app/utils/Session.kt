package com.example.traineeandleveli.app.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager


class Session(cntx: Context?) {
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(cntx)

    fun setData(key: String?, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun getData(key: String?): String? {
        return prefs.getString(key, "")
    }

}
