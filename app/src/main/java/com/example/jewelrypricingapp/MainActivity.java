package com.example.jewelrypricingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
CardView Ring, Bracelet, Neckalce, Earrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ring = findViewById(R.id.Ring);
        Bracelet = findViewById(R.id.Bracelet);
        Neckalce = findViewById(R.id.Necklace);
        Earrings = findViewById(R.id.Earrings);

        Ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Rlist.class);
                startActivity(intent);

            }

        });

        Bracelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Blist.class);
                startActivity(intent);

            }

        });

        Neckalce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Nlist.class);
                startActivity(intent);

            }

        });

        Earrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Elist.class);
                startActivity(intent);

            }

        });
    }
}