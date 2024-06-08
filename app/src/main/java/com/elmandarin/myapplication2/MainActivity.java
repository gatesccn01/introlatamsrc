package com.elmandarin.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.elmandarin.intromandarin.MyIntro;

public class MainActivity extends AppCompatActivity {
    private static String PREFS_KEY = "mispreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean muestra = getValuePreference(getApplicationContext());
        if (muestra) {
            Intent myIntent = new Intent(this, MyIntro.class);
            startActivity(myIntent);
            saveValuePreference(getApplicationContext(), false);
        }
        setContentView(R.layout.activity_main);

    }

    public static void saveValuePreference(Context context, Boolean mostrar) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putBoolean("license", mostrar);
        editor.commit();
    }

    public static boolean getValuePreference(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return preferences.getBoolean("license", true);
    }


}