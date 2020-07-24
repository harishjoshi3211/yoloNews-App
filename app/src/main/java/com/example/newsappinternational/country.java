package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class country extends AppCompatActivity {

    TextView india,us,japan,uae,nz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        india=findViewById(R.id.india);
        us=findViewById(R.id.us);
        japan=findViewById(R.id.japan);
        uae=findViewById(R.id.uae);
        nz=findViewById(R.id.nz);

        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(country.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?country=in&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(country.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?country=us&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(country.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?country=jp&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        uae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(country.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?country=ae&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(country.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?country=nz&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });
    }
}
