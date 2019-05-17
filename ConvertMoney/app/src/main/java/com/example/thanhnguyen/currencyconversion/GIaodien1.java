package com.example.thanhnguyen.currencyconversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GIaodien1 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien1);
        /*setContentView(R.layout.temperature);*/

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        LinearLayout data = findViewById(R.id.data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GIaodien1.this, Datastorage.class);
                startActivity(intent);
            }
        });

        LinearLayout tem = findViewById(R.id.tem);
        tem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GIaodien1.this, Temperature.class);
                startActivity(intent);
            }
        });

        LinearLayout weight = findViewById(R.id.weight);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GIaodien1.this, Weight.class);
                startActivity(intent);
            }
        });

        LinearLayout currency = findViewById(R.id.currency);
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GIaodien1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout length = findViewById(R.id.length);
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GIaodien1.this, Length.class);
                startActivity(intent);
            }
        });

        LinearLayout time = findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GIaodien1.this, BMI.class);
                startActivity(intent);
            }
        });

    }
}
