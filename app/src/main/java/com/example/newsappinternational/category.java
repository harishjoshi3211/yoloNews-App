package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class category extends AppCompatActivity {

    Button bus,ent,hea,gen,sci,spo,tec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        bus=findViewById(R.id.bus);
        ent=findViewById(R.id.ent);
        hea=findViewById(R.id.hea);
        gen=findViewById(R.id.gen);
        sci=findViewById(R.id.sci);
        spo=findViewById(R.id.spo);
        tec=findViewById(R.id.tec);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=business&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=entertainment&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        hea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=health&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=general&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=science&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        spo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=sports&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(category.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?category=technology&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });
    }
}
