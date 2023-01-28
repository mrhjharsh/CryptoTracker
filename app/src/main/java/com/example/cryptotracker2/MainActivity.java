package com.example.cryptotracker2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
public static EditText searchEdt;
public static int pos  = 0;
public static ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv;
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        rv = findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        CustomAdapter ca = new CustomAdapter();
        rv.setAdapter(ca);
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                       // Snackbar.make(view,CustomAdapter.text[position],Snackbar.LENGTH_LONG ).show();
pos = position;
                        Intent i = new Intent(MainActivity.this,crypto_details.class);
startActivity(i);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }


    public static void getData(Context c) {
        // creating a variable for storing our string.
        String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        // creating a variable for request queue.
        RequestQueue queue = Volley.newRequestQueue(c);
        // making a json object request to fetch data from API.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // inside on response method extracting data
                // from response and passing it to array list
                // on below line we are making our progress
                // bar visibility to gone.
                try {
                    // extracting data from json.
                    JSONArray dataArray = response.getJSONArray("data");
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject dataObj = dataArray.getJSONObject(i);
                        String symbol = dataObj.getString("symbol");
                        String name = dataObj.getString("name");
                        JSONObject quote = dataObj.getJSONObject("quote");
                        JSONObject USD = quote.getJSONObject("USD");
                        float price =(float) USD.getDouble("price");
                        // adding all data to our array list.
                        String volume_24h = USD.getString("volume_24h");
                        String volume_change_24h= USD.getString("volume_change_24h");
                        String percent_change_1h = USD.getString("percent_change_1h");
                        String percent_change_24h = USD.getString("percent_change_24h");
                        String percent_change_7d = USD.getString("percent_change_7d");
                        String percent_change_30d = USD.getString("percent_change_30d");
                        String percent_change_60d = USD.getString("percent_change_60d");
                        String percent_change_90d = USD.getString("percent_change_90d");
                        String market_cap = USD.getString("market_cap");
                        DATABASE.aa1.add(volume_24h);
                        DATABASE.aa2.add(volume_change_24h);
                        DATABASE.aa3.add(percent_change_1h);
                        DATABASE.aa4.add(percent_change_24h);
                        DATABASE.aa5.add(percent_change_7d);
                        DATABASE.aa6.add(percent_change_30d);
                        DATABASE.aa7.add(percent_change_60d);
                        DATABASE.aa8.add(percent_change_90d);
                        DATABASE.aa9.add(market_cap);
                        DATABASE.crypto_name.add(name);
                        DATABASE.crypto_name_nick.add(String.valueOf(price)+" $");
                        DATABASE.crypto_name_price.add(symbol);
                    }

                    // notifying adapter on data change.
                } catch (JSONException e) {
                    // handling json exception.
                    e.printStackTrace();
                    Toast.makeText(c, "Something went amiss. Please try again later", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // displaying error response when received any error.
                Toast.makeText(c, "Something went amiss. Please try again later", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                // in this method passing headers as
                // key along with value as API keys.
                HashMap<String, String> headers = new HashMap<>();
                headers.put("X-CMC_PRO_API_KEY", "3766e5bc-1950-4976-8df0-5151df5f94da");
                // at last returning headers
                return headers;
            }
        };
        // calling a method to add our
        // json object request to our queue.
        queue.add(jsonObjectRequest);
    }
}