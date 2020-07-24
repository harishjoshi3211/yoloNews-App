package com.example.newsappinternational;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.Serializable;
import java.util.ArrayList;

public class adapter  extends RecyclerView.Adapter<adapter.ViewHolder>{

    public ArrayList<news> newslist;
    itemclicked context;
    private itemclicked mlistener;
    public final Context mlo;
    public interface itemclicked
    {
        void onitemclicked(int index);
    }
    public void setMlistener(itemclicked listener)
    {
        mlistener=listener;
    }
    //constructor
    public adapter(ArrayList<news> li, Context context_)
    {
        mlo=context_;
        newslist = li;
        context = (itemclicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView image;
        private TextView title;
        private TextView author;
        private TextView name;
        private TextView publish;

        public ViewHolder(View v)
        {
            super(v);
            image =(ImageView)v.findViewById(R.id.img);
            title=(TextView)v.findViewById(R.id.titleid);
            author=(TextView)v.findViewById(R.id.author);
            name=(TextView)v.findViewById(R.id.name);
            publish=(TextView)v.findViewById(R.id.publish);



        }

        public ImageView getImage(){ return this.image;}
    }

    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final adapter.ViewHolder holder, final int position)
    {
            Glide.with(holder.itemView.getContext())
                    .load(newslist.get(position).getImgurl())
                    .override(400,400)
                    .into(holder.getImage());


        holder.title.setText(newslist.get(position).getTitle());
        holder.author.setText(newslist.get(position).getAuthor());
        holder.name.setText(newslist.get(position).getName());
        holder.publish.setText(newslist.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> eve=new ArrayList<>();
                eve.add(newslist.get(position).getTitle());
                eve.add(newslist.get(position).getName());
                eve.add(newslist.get(position).getTime());
                eve.add(newslist.get(position).getAuthor());
                eve.add(newslist.get(position).getContent());
                eve.add(newslist.get(position).getImgurl());
                Intent intent=new Intent(v.getContext(),briefnews.class);
                intent.putExtra("all",eve);
                v.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount()
    {
        return newslist.size();
    }

}
