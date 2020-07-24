package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.lang.Boolean;

public class showbycat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbycat);

        //Intent intent=getIntent();
        int[] myArr= getIntent().getIntArrayExtra("arr");
        // Output the array
        int x=0;
        for(int item:myArr){
            if(item==1)
            {
                Toast.makeText(showbycat.this,x+" ",Toast.LENGTH_SHORT).show();
            }
            x++;
        }


    }
}
