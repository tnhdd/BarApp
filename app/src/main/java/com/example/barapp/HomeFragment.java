package com.example.barapp;

import android.app.slice.Slice;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {
    public CardView cocktails, whiskey, shot, setting;
    Fragment CocktailFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cocktails = view.findViewById(R.id.cvCocktails);
        cocktails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CocktailFragment cocktailFragment = new CocktailFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_home, cocktailFragment, null)
                        .addToBackStack(null).commit();
                //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cocktailFragment);

            }
        });
        /*cocktails.setOnClickListener(view1 -> {
            CocktailFragment cocktailFragment = new CocktailFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_home, cocktailFragment, null)
                    .addToBackStack(null).commit();

        });*/

        whiskey = view.findViewById(R.id.cvWhiskey);
        whiskey.setOnClickListener(view2 -> {
            WhiskeyFragment whiskeyFragment = new WhiskeyFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_home, whiskeyFragment, null)
                    .addToBackStack(null).commit();
        });

        shot = view.findViewById(R.id.cvShot);
        shot.setOnClickListener(view3 -> {
            ShotFragment shotFragment = new ShotFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_home, shotFragment, null)
                    .addToBackStack(null).commit();
        });

        setting = view.findViewById(R.id.cvSetting);
        setting.setOnClickListener(view4-> {
            SettingFragment settingFragment = new SettingFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_home, settingFragment, null)
                    .addToBackStack(null).commit();
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}