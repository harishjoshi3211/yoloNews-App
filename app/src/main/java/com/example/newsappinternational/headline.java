package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class headline extends AppCompatActivity {

    CheckBox in,us,jp,bus,ent,hea,gen,sci,spo,tec;
    Button go;
    public int[] array = new int[10];
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headline);


        Arrays.fill(array, 0);
        in=findViewById(R.id.in);
        us=findViewById(R.id.us);
        jp=findViewById(R.id.jp);
        bus=findViewById(R.id.bus);
        ent=findViewById(R.id.ent);
        hea=findViewById(R.id.hea);
        gen=findViewById(R.id.gen);
        sci=findViewById(R.id.sci);
        spo=findViewById(R.id.spo);
        tec=findViewById(R.id.tec);
        go=findViewById(R.id.go);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list=new ArrayList<>();

                if (in.isChecked())
                {
                    array[0]=1;
                }

                if (us.isChecked())
                {
                    array[1]=1;
                }

                if (jp.isChecked())
                {
                    array[2]=1;
                }

                if (bus.isChecked())
                {
                    array[3]=1;
                }

                if (ent.isChecked())
                {
                    array[4]=1;
                }

                if (hea.isChecked())
                {
                    array[5]=1;
                }

                if (gen.isChecked())
                {
                    array[6]=1;
                }

                if (sci.isChecked())
                {
                    array[7]=1;
                }

                if (spo.isChecked())
                {
                    array[8]=1;
                }

                if (tec.isChecked())
                {
                    array[9]=1;
                }

                boolean flag1=false,flag2=false;
                for(int i=0;i<=9;i++)
                {
                    if(array[i]==1&&(i<3))
                    {
                        flag1=true;
                    }
                    if(array[i]==1&&(i>=3))
                    {
                        flag2=true;
                    }
                }
                int i,j;
                if(flag1&&flag2)
                {
                    for(i=0;i<3;i++)
                    {
                        for(j=3;j<=9;j++)
                        {
                            if(array[i]==1&&(array[j]==1))
                            {
                                addarraylist(i,j);
                            }
                        }
                    }
                }
                else if(flag1)
                {
                    for(i=0;i<3;i++)
                    {
                        addarraylist(i,-1);
                    }
                }
                else if(flag2)
                {
                    for(i=3;i<=9;i++)
                    {
                        addarraylist(-1,1);
                    }
                }
                else
                {
                    Toast.makeText(headline.this,"please select atleast one choice",Toast.LENGTH_SHORT).show();
                }
                if(flag1||flag2)
                {
                    Arrays.fill(array, 0);
                    Intent intent=new Intent(headline.this,shownews.class);
                    intent.putStringArrayListExtra("all",list);
                    startActivity(intent);
                    //Toast.makeText(headline.this," "+list.get(0),Toast.LENGTH_SHORT).show();
                }



            }
        });



    }
    public void addarraylist(int i,int j)
    {
        String url="https://newsapi.org/v2/top-headlines?";
        if(i==-1)
        {

        }
        else {
            switch (i) {
                case 0:
                    url=url.concat("country=in");
                    break;
                case 1:
                    url=url.concat("country=us");
                    break;
                case 2:
                    url=url.concat("country=jp");
                    break;

            }
        }
        if(j==-1)
        {

        }
        else {
            if(i!=-1)
                url=url.concat("&");
            switch (j) {
                case 3:
                    url=url.concat("category=entertainment");
                    break;
                case 4:
                    url=url.concat("category=business");
                    break;
                case 5:
                    url=url.concat("category=general");
                    break;
                case 6:
                    url=url.concat("category=health");
                    break;
                case 7:
                    url=url.concat("category=sports");
                    break;
                case 8:
                    url=url.concat("category=science");
                    break;
                case 9:
                    url=url.concat("category=technology");
                    break;
            }
        }
        url=url.concat("&apiKey=d09e6d5a14fb43d99fc995c5638a39af");
        list.add(url);
    }
}
