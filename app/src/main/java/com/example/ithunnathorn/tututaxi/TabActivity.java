package com.example.ithunnathorn.tututaxi;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class TabActivity extends AppCompatActivity
        implements PassentgerFragment.OnFragmentInteractionListener
        ,DriverFragment.OnFragmentInteractionListener
        ,HelpFragment.OnFragmentInteractionListener
        ,MapFragment.OnFragmentInteractionListener{

    BottomNavigationView navigation;

    PassentgerFragment passentgerFragment;
    DriverFragment driverFragment;
    HelpFragment helpFragment;
    MapFragment mapFragment;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (navigation.getSelectedItemId() == R.id.navigation_home){
                        return true;
                    }
                    if (passentgerFragment == null){
                        passentgerFragment = new PassentgerFragment();
                        passentgerFragment.setArguments(getIntent().getExtras());
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_contrainer,passentgerFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    if (navigation.getSelectedItemId() == R.id.navigation_dashboard){
                        return true;
                    }
                    if (driverFragment == null){
                        driverFragment = new DriverFragment();
                        driverFragment.setArguments(getIntent().getExtras());
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_contrainer,driverFragment).commit();
                    return true;
//                case R.id.navigation_notifications:
//                    if (navigation.getSelectedItemId() == R.id.navigation_notifications){
//                        return true;
//                    }
//                    if (helpFragment == null){
//                        helpFragment = new HelpFragment();
//                        helpFragment.setArguments(getIntent().getExtras());
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_contrainer,helpFragment).commit();
//                    return true;
                case R.id.navigation_maps:
                    if (navigation.getSelectedItemId() == R.id.navigation_maps){
                        return true;
                    }
                    if (mapFragment == null){
                        mapFragment = new MapFragment();
                        mapFragment.setArguments(getIntent().getExtras());
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_contrainer,mapFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        passentgerFragment = new PassentgerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_contrainer,passentgerFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
