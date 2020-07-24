package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button searchbtn,headline,lang,categ,publications,country;
    TextView name,tag,tv1,tv2,tv3;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchbtn=findViewById(R.id.searchbtn);
        headline=findViewById(R.id.headline);
        lang=findViewById(R.id.lang);
        categ=findViewById(R.id.categ);
        name=findViewById(R.id.name);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tag=findViewById(R.id.tag);
        publications=findViewById(R.id.publications);
        search=findViewById(R.id.search);
        country=findViewById(R.id.country);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query=search.getText().toString().trim();
                if(query.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "input keyword", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,shownews.class);
                    ArrayList<String> array=new ArrayList<>();
                    String url="https://newsapi.org/v2/top-headlines?q=";
                    url=url.concat(query);
                    url=url.concat("&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                    array.add(url);
                    intent.putStringArrayListExtra("all",array);
                    startActivity(intent);
                }

            }
        });

        headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, com.example.newsappinternational.headline.class);

                startActivity(intent);

            }
        });

        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, language.class);

                startActivity(intent);
            }
        });

        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, category.class);

                startActivity(intent);

            }
        });

        publications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, publications.class);

                startActivity(intent);
            }
        });

        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, country.class);

                startActivity(intent);
            }
        });


    }
}
