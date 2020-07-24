package com.example.newsappinternational;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class shownews extends AppCompatActivity implements adapter.itemclicked {

    RecyclerView rv;
    public static final String LOG_TAG = "YOUR-TAG-NAME";
    TextView tv;
    ArrayList<news> list=new ArrayList<>();
    int recsize=0;
    String requrl;
    int z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownews);

        rv=findViewById(R.id.rv);
        tv=findViewById(R.id.tv);
        //RecyclerView rec = (RecyclerView) findViewById(R.id.recyclerview);

        Intent intent = getIntent();
        ArrayList<String> object = (ArrayList<String>)intent.getStringArrayListExtra("all");

        int l=object.size();
        z=50/l;
        for(int i=0;i<l;i++)
        {
            recsize=0;
            requrl=object.get(i);
            newsAsyncTask task = new newsAsyncTask();
            task.execute();

        }





    }

    public void update(ArrayList<news> obj)
    {
        int i=0;
        while(i<obj.size())
        {
            list.add(obj.get(i));
            i++;
        }
        Toast.makeText(shownews.this,"parsed "+list.size(),Toast.LENGTH_SHORT).show();

        adapter myadapter = new adapter(list, shownews.this);
        rv.setAdapter(myadapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onitemclicked(int index) {

    }


    /**
     * {@link AsyncTask} to perform the network request on a background thread, and then
     * update the UI with the first earthquake in the response.
     */
    private class newsAsyncTask extends AsyncTask<URL, Void, ArrayList<news>> {

        @Override
        protected ArrayList<news> doInBackground(URL... urls) {
            // Create URL object
            URL url = createUrl(requrl);

            // Perform HTTP request to the URL and receive a JSON response back
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                // TODO Handle the IOException
            }

            // Extract relevant fields from the JSON response and create an {@link Event} object
            ArrayList<news> obj=extractFeatureFromJson(jsonResponse);

            // Return the {@link Event} object as the result fo the {@link TsunamiAsyncTask}
            return obj;
        }

        @Override
        protected void onPostExecute(ArrayList<news> obj) {
            super.onPostExecute(obj);

            update(obj);
            return;
        }


        /**
         * Returns new URL object from the given string URL.
         */
        private URL createUrl(String stringUrl) {
            URL url = null;
            try {
                url = new URL(stringUrl);
            } catch (MalformedURLException exception) {
                Log.e(LOG_TAG, "Error with creating URL", exception);
                return null;
            }
            return url;
        }

        /**
         * Make an HTTP request to the given URL and return a String as the response.
         */
        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } catch (IOException e) {
                // TODO: Handle the exception
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    // function must handle java.io.IOException here
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        /**
         * Convert the {@link InputStream} into a String which contains the
         * whole JSON response from the server.
         */
        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }

        private ArrayList<news> extractFeatureFromJson(String newss) {
            ArrayList<news> eqlist=new ArrayList<news>();
            try {
                JSONObject baseJsonResponse = new JSONObject(newss);
                JSONArray featureArray = baseJsonResponse.getJSONArray("articles");

                // If there are results in the features array
                if (featureArray.length() > 0) {
                    while((recsize<z)&&(recsize<featureArray.length())) {
                        // Extract out the first feature (which is an earthquake)
                        JSONObject obj = featureArray.getJSONObject(recsize);
                        JSONObject source = obj.getJSONObject("source");

                        // Extract out the title, time, and tsunami values
                        String name = source.getString("name");
                        String title=obj.getString("title");
                        String content=obj.getString("content");
                        String urltoimg=obj.getString("urlToImage");
                        String author=obj.getString("author");
                        String time=obj.getString("publishedAt");
                        // Create a new {@link Event} object
                        recsize=recsize+1;
                        news event=new news(title, name,urltoimg,author,content,time);
                        eqlist.add(event);

                    }
                }
                return eqlist;

            } catch (JSONException e) {
                Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);
            }
            return eqlist;
        }
    }
}
