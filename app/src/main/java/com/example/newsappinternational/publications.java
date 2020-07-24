package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class publications extends AppCompatActivity {

    ImageView bbc,abc,cnn,fox,buzzfeed,espn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publications);

        abc=findViewById(R.id.abc);
        bbc=findViewById(R.id.bbc);
        cnn=findViewById(R.id.cnn);
        fox=findViewById(R.id.fox);
        buzzfeed=findViewById(R.id.buzzfeed);
        espn=findViewById(R.id.espn);



        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(publications.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?sources=abc-news&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        bbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(publications.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        cnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(publications.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        fox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(publications.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?sources=fox-news&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);


            }
        });

        buzzfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(publications.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?sources=buzzfeed&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });

        espn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(publications.this,shownews.class);
                ArrayList<String> array=new ArrayList<>();
                array.add("https://newsapi.org/v2/top-headlines?sources=espn&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                intent.putStringArrayListExtra("all",array);
                startActivity(intent);

            }
        });
    }
}
