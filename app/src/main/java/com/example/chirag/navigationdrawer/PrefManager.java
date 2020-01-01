package com.example.chirag.navigationdrawer;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

SharedPreferences pref;
SharedPreferences.Editor editor;
Context _context;

int private_mode=0;

private static final String PREF_NAME = "androidhive-welcome";

private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, private_mode);
        editor = pref.edit();
    }

    public void setIsFirstTimeLaunch(boolean isFirstTimeLaunch)
    {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTimeLaunch);
            editor.commit();
    }

    public boolean IsFirstTimeLaunch()
    {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
