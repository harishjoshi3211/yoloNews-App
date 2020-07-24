package com.example.newsappinternational;

import android.app.Application;

import com.backendless.Backendless;

public class applicationclass extends Application {

    public static final String APP_ID="C2EA7FD4-F30F-3F97-FFB7-0EEC5C528900";
    public static final String API_key="CDE98A08-42C1-4952-A163-3AF2913BE574";
    public static final String SERVER_URL="https://api.backendless.com";

    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APP_ID,
                API_key );

    }
}
