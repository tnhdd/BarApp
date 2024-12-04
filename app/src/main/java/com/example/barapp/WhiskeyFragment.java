package com.example.barapp;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WhiskeyFragment extends Fragment {

    public CardView whiskeySour, whiskeyOnTheRock;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_whiskey, container, false);

        whiskeySour = view.findViewById(R.id.cv_whiskey_sour);
        whiskeySour.setOnClickListener(view1 -> {
            WhiskeySour whiskeySour = new WhiskeySour();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_whiskey, whiskeySour, null)
                    .addToBackStack(null).commit();

        });

        whiskeyOnTheRock = view.findViewById(R.id.cv_whiskey_ontherock);
        whiskeyOnTheRock.setOnClickListener(view1 -> {
            WhiskeyOnTheRock onTheRock = new WhiskeyOnTheRock();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_whiskey, onTheRock, null)
                    .addToBackStack(null).commit();

        });

        return view;
    }
}