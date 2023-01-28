package com.example.cryptotracker2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.TextView;

public class crypto_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_crypto_details);
        TextView tf1 = findViewById(R.id.tf1);
        TextView tf2 = findViewById(R.id.tf2);
        TextView tf3 = findViewById(R.id.tf3);
        TextView tf4 = findViewById(R.id.tf4);
        TextView tf5 = findViewById(R.id.tf5);
        TextView tf6 = findViewById(R.id.tf6);
        TextView tf7 = findViewById(R.id.tf7);
        TextView tf8 = findViewById(R.id.tf8);
        TextView tf9 = findViewById(R.id.tf9);

            tf1.setText("volume_24h:              "+DATABASE.aa1.get(MainActivity.pos));
            tf2.setText("volume_change_24h:       "+DATABASE.aa2.get(MainActivity.pos));
            tf3.setText("percent_change_1h:       "+DATABASE.aa3.get(MainActivity.pos)+"%");
            tf4.setText("percent_change_24h:      "+DATABASE.aa4.get(MainActivity.pos)+"%");
            tf5.setText("percent_change_7d:       "+DATABASE.aa5.get(MainActivity.pos)+"%");
            tf6.setText("percent_change_30d:      "+DATABASE.aa6.get(MainActivity.pos)+"%");
            tf7.setText("percent_change_60d:      "+DATABASE.aa7.get(MainActivity.pos)+"%");
            tf8.setText("percent_change_90d:      "+DATABASE.aa8.get(MainActivity.pos)+"%");
            tf9.setText("market_cap:              "+DATABASE.aa9.get(MainActivity.pos));







    }
}