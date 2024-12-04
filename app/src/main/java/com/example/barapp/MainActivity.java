package com.example.barapp;

import static com.example.barapp.R.id;
import static com.example.barapp.R.layout;
import static com.example.barapp.R.string;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);


        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(id.drawer_layout);

        NavigationView navigationView = findViewById(id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, string.open_nav, string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(id.nav_home);
        }
        //cocktails = findViewById(id.cvCocktails);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String language = preferences.getString("language","");
        if (!language.equals("")){
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        }
        int restoredSelectedRadioButtonId = preferences.getInt("selectedRadioButtonId", -1);
        if (restoredSelectedRadioButtonId != -1) {
            RadioButton restoredRadioButton = findViewById(restoredSelectedRadioButtonId);
            restoredRadioButton.setChecked(true);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container, new HomeFragment()).commit();

                break;
            case id.nav_cocktails:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new CocktailFragment()).commit();
                // startActivity(new Intent(this,CocktailActivity.class));
                break;
            case id.nav_shot:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new ShotFragment()).commit();
                break;
            case id.nav_whiskey:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new WhiskeyFragment()).commit();
                break;
            case id.nav_setting:
                getSupportFragmentManager().beginTransaction().replace(id.fragment_container,new SettingFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        // searchView.setQueryHint(getString(R.string.hi));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                // .getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}