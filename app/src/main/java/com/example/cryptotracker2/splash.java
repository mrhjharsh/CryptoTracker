package com.example.cryptotracker2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_splash);
        MainActivity.getData(getApplicationContext());
        if(CheckNetwork.isInternetAvailable(splash.this)) //returns true if internet available
        {
            MainActivity.getData(splash.this);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent i = new Intent(splash.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
            },3000);

               }
        else
        {
            Toast.makeText(splash.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }






    }
}