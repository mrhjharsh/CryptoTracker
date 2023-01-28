package com.example.cryptotracker2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    static String[] text1 = new String[DATABASE.crypto_name.size()];
    static String[] text2 = new String[DATABASE.crypto_name.size()];
    static String[] text3 = new String[DATABASE.crypto_name.size()];

    CustomAdapter(){
            for (int i = 0; i < text1.length; i++){
                text1[i] = DATABASE.crypto_name.get(i);
                text2[i] = DATABASE.crypto_name_price.get(i);
                text3[i] = DATABASE.crypto_name_nick.get(i);
            }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.rv, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt1.setText(text1[position]);
        holder.txt2.setText(text2[position]);
        holder.txt3.setText(text3[position]);
    }

    @Override
    public int getItemCount() {
        //esse recycler view me kitne view visible rhe ye decide hota ha
        return text1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        TextView txt2;
        TextView txt3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.real);
            txt2 = itemView.findViewById(R.id.nick);
            txt3 = itemView.findViewById(R.id.price);
        }
    }
}
