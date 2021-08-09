package com.appdevelopersumankr.welcome_page;

import android.content.Context;
import android.content.SharedPreferences;

public class Launcher_Manager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static String PREF_NAME="LaunchManager";
    private static String IS_FIRST_TIME="isFirst";

    public Launcher_Manager(Context context) {
        sharedPreferences=context.getSharedPreferences ( PREF_NAME,0 );
        editor=sharedPreferences.edit ();
    }
    public void setFirstLaunch(boolean isfirst){
        editor.putBoolean ( IS_FIRST_TIME,isfirst);
        editor.commit ();
    }
    public boolean isfirsttime(){
        return sharedPreferences.getBoolean ( IS_FIRST_TIME,true);
    }
}
