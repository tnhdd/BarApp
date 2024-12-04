package com.example.barapp;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;


public class SettingFragment extends Fragment implements View.OnClickListener {
    private RadioButton rdEnglish, rdSpanish;
    private RadioGroup rgLanguage;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        rdEnglish = view.findViewById(R.id.rb_english);
        rdSpanish = view.findViewById(R.id.rb_spanish);
        rgLanguage = view.findViewById(R.id.rg_language);

        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        int selectedRadioButtonId = rgLanguage.getCheckedRadioButtonId();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("selectedRadioButtonId", selectedRadioButtonId);
        editor.apply();

       rdEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage("en");
            }
        });
        rdSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage("es");
            }
        });

        /*rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_english:
                        setLanguage("en");
                        break;
                    case R.id.rb_spanish:
                        setLanguage("es");
                        break;
                }
            }
        });*/


        return view;
    }

    @Override
    public void onClick(View view) {

    }

    public void setLanguage(String language) {
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        editor = preferences.edit();
        editor.putString("language", language);
        editor.apply();
        Locale newLocale = new Locale(language);
        Configuration config = getResources().getConfiguration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        getActivity().recreate();
    }
}