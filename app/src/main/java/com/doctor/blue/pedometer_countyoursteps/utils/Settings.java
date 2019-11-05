package com.doctor.blue.pedometer_countyoursteps.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.doctor.blue.pedometer_countyoursteps.keys.SettingKey;

public class Settings {
    private SharedPreferences preferences;
    private Context context;
    @SuppressLint("StaticFieldLeak")
    private static volatile Settings SETTINGS;
    private SharedPreferences.Editor mEditor;

    private Settings(Context context){
        this.context=context;
        preferences=context.getSharedPreferences("Settings",Context.MODE_PRIVATE);
    }
    public static Settings getInstance(Context context){
        if (SETTINGS==null){
            synchronized (Settings.class){
                if (SETTINGS==null){
                    SETTINGS=SettingHelper.getSettings(context );
                }
            }
        }
        return SETTINGS;
    }
    private static class SettingHelper{
        private static Settings getSettings(Context context){
            return new Settings(context.getApplicationContext());
        }
    }
    //Put String data to SharedPreferences xml file
    public void put(SettingKey keys,String values){
        doEdit();
        mEditor.putString(keys.toString(),values);
        doApply();
    }
    //Put int data to SharedPreferences xml file
    public void put(SettingKey key,int value){
        doEdit();
        mEditor.putInt(key.toString(),value);
        doApply();
    }
    //Put boolean data to SharedPreferences xml file
    public void put(SettingKey key, boolean value){
        doEdit();
        mEditor.putBoolean(key.toString(),value);
        doApply();
    }
    //retrieve data of type int from SharedPreferences xml file
    public int getInt(SettingKey key){
        return preferences.getInt(key.toString(),0);
    }
    //retrieve data of type boolean from SharedPreferences xml file
    public boolean getBoolean(SettingKey key){
        return preferences.getBoolean(key.toString(),false);
    }
    //retrieve data of type String from SharedPreferences xml file
    public String getString(SettingKey key){
        return preferences.getString(key.toString(),"");
    }
    @SuppressLint("CommitPrefEdits")
    private void doEdit(){
        if (mEditor==null){
            mEditor=preferences.edit();
        }
    }
    private void doApply(){
        if (mEditor!=null){
            mEditor.apply();
        }
    }
}
