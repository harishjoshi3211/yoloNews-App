package com.example.newsappinternational;

public class news {

    private String title;
    private String imgurl;
    private String author;
    private String name;
    private String content;
    private String time;


    public news(String title, String name, String imgurl,String author,String content,String time) {
        this.title = title;
        this.imgurl = imgurl;
        this.author=author;
        this.content=content;
        this.name=name;
        this.time=time;
    }

    public String getTitle()
    {
        return title;
    }

    public String getName()
    {
        return name;
    }
    public String getImgurl()
    {
        return imgurl;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getContent()
    {
        return content;
    }

    public String getTime()
    {
        return time;
    }
}
