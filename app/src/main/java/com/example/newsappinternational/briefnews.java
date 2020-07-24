package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class briefnews extends AppCompatActivity {

    TextView title,author,name,time,content;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_briefnews);

        title=findViewById(R.id.titlenews);
        author=findViewById(R.id.author);
        name=findViewById(R.id.name);
        time=findViewById(R.id.date);
        content=findViewById(R.id.newscontent);
        img=findViewById(R.id.img);

        Intent intent = getIntent();
        ArrayList<String> object = (ArrayList<String>)intent.getStringArrayListExtra("all");

        title.setText(object.get(0));
        author.setText(object.get(3));
        name.setText(object.get(1));
        time.setText(object.get(2));
        content.setText(object.get(4));
        Glide.with(this)
                .load(object.get(5))
                .override(200,200)
                .into(img);
        /*Intent intent = getIntent();
        ArrayList<news> obj = (ArrayList<news>) intent.getSerializableExtra("all");
        news object=obj.get(0);
        title.setText(object.getTitle());
        author.setText(object.getAuthor());
        name.setText(object.getName());
        time.setText(object.getTime());
        content.setText(object.getContent());

         */

    }
}
