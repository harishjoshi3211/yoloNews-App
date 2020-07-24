package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class language extends AppCompatActivity {

    CheckBox ch1,ch2;
    Button go;
    public int[] arr = new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        arr[0]=0;
        arr[1]=0;
        ch1=findViewById(R.id.ch1);
        ch2=findViewById(R.id.ch2);
        go=findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ch1.isChecked())
                {
                    arr[0]=1;
                }
                if(ch2.isChecked())
                {
                    arr[1]=1;
                }
                String url="https://newsapi.org/v2/everything?domains=";
                if(arr[0]==1||arr[1]==1)
                {
                    if(arr[0]==1)
                    {
                        url=url.concat("techcrunch.com");
                    }
                    if(arr[1]==1)
                    {
                        if(arr[0]==1)
                        {
                            url=url.concat(",thenextweb.com");
                        }
                        else
                        {
                            url=url.concat("thenextweb.com");
                        }
                    }
                    url=url.concat("&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
                    Intent intent=new Intent(language.this,shownews.class);
                    ArrayList<String> array=new ArrayList<>();
                    array.add(url);
                    intent.putStringArrayListExtra("all",array);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(language.this,"Select Atleast one Choice",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
