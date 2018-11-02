package com.example.povtoryau;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Администратор on 02.11.2018.
 */

public class DataSource extends AsyncTask<Void,Void,String> {

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL tyta = new URL ("http://test.areas.su/api/users");
            urlConnection = (HttpURLConnection) tyta.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine())!=null){
                buffer.append(line);
            }
            resultJson = buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }
}
