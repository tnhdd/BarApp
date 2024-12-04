package com.example.barapp;

import static com.example.barapp.R.id.cvBloody_Mary;
import static com.example.barapp.R.id.cvMargarita;
import static com.example.barapp.R.id.cvMojito;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CocktailFragment extends Fragment implements View.OnClickListener {
    public CardView martini, bloody_mary, margarita, mojito;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cocktail, container, false);

        martini = view.findViewById(R.id.cvMartini);
        martini.setOnClickListener(view1 -> {
            CocktailMartini martiniFragment = new CocktailMartini();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_cocktail, martiniFragment, null)
                    .addToBackStack(null).commit();

        });

        bloody_mary = view.findViewById(cvBloody_Mary);
        bloody_mary.setOnClickListener(view1 -> {
            CocktailBloodyMary cocktailBloodyMary = new CocktailBloodyMary();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_cocktail, cocktailBloodyMary, null)
                    .addToBackStack(null).commit();

        });

        margarita = view.findViewById(cvMargarita);
        margarita.setOnClickListener(view1 -> {
            CocktailMargarita cocktailMargarita = new CocktailMargarita();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_cocktail, cocktailMargarita, null)
                    .addToBackStack(null).commit();

        });

        mojito = view.findViewById(cvMojito);
        mojito.setOnClickListener(view1 -> {
            CocktailMojito cocktailMojito = new CocktailMojito();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_cocktail, cocktailMojito, null)
                    .addToBackStack(null).commit();

        });
        return view;
    }

    @Override
    public void onClick(View view) {

    }

}