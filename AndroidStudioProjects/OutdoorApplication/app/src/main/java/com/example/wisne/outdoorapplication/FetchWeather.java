package com.example.wisne.outdoorapplication;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import android.os.AsyncTask;
import java.net.URL;
//import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by wisne on 3/8/2018.
 */

public class FetchWeather extends AsyncTask<String,Void,String>{



        @Override
         protected String doInBackground(String... urls){
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            String lat = "";
            String lon = "";
            try {
                url = new URL(urls[0]);
                String OPEN_WEATHER_MAP_API =
                      "http://api.openweathermap.org/data/2.5/forecast?&units=imperial&lat=48.846700&lon=-121.692324&appid=75d42cf579d66be3fda8ee90c9cba6e3";

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;

                    result += current;

                    data = reader.read();

                    Log.i("Messages 123",Integer.toString(data));

                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            return null;


        }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {
            JSONObject jsonObject = new JSONObject(result);

            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));

            double temperature = Double.parseDouble(weatherData.getString("temp"));

            MainActivity.textView.setText(String.valueOf(temperature));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
