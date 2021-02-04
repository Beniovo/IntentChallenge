package com.example.beniovosolutions;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFRag.itemSelected {

    TextView tvDescription;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        description = getResources().getStringArray(R.array.descriptions);

        //the phone is in portrait mode
        if(findViewById(R.id.layout_potrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                            .hide(manager.findFragmentById(R.id.detailfrag))
                            .show(manager.findFragmentById(R.id.listfrag))
                            .addToBackStack(null)
                            .commit();

        }

        //the phone is in landscape
        if(findViewById(R.id.layout_land) != null){

            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfrag))
                    .show(manager.findFragmentById(R.id.listfrag))
                    .commit();

        }



    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(description[index]);
        FragmentManager manager = this.getSupportFragmentManager();

        manager.beginTransaction()
                .show(manager.findFragmentById(R.id.detailfrag))
                .hide(manager.findFragmentById(R.id.listfrag))
                .commit();


    }
}
