package com.example.barapp;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ShotFragment extends Fragment {

    public CardView b52, tequila, sambaca;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shot, container, false);

        b52 = view.findViewById(R.id.cv_shot_B52);
        b52.setOnClickListener(view1 -> {
            ShotB52 shotB52 = new ShotB52();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_shot, shotB52, null)
                    .addToBackStack(null).commit();
        });
        tequila = view.findViewById(R.id.cv_shot_Tequila);
        tequila.setOnClickListener(view1 -> {
            ShotTequila tequila = new ShotTequila();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_shot, tequila, null)
                    .addToBackStack(null).commit();
        });
        sambaca = view.findViewById(R.id.cv_shot_sambuca);
        sambaca.setOnClickListener(view1 -> {
            ShotSambaca sambaca = new ShotSambaca();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_shot, sambaca, null)
                    .addToBackStack(null).commit();
        });

        return view;
    }
}