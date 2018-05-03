package com.example.ananmayjain.soccerstats;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class extract_json extends AppCompatActivity {
    private static final String TAG = "Final_Project:Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void Standings(String id, RequestQueue requestQueue) {

        String apikey = "ddf28c2cf73347024f8ed8fd3a0e04fbf2f192c35be67012099d985aa569f82b";
        String url = "https://apifootball.com/api/?action=get_standings&league_id=" + id
                + "&APIkey=" + apikey;
        Log.d(TAG, "HERE 1");
        try {
            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(final JSONArray response) {
                            try {
                                Log.d(TAG, "Here 2");
                                setContentView(R.layout.data);
                                TextView box = findViewById(R.id.display);
                                Log.d(TAG, response.getJSONObject(0).toString());
                                String x = response.getJSONObject(0).toString();
                            } catch (Exception e) {
                                Log.d(TAG, e.toString());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.d(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

                    /**HttpURLConnection connection = (HttpURLConnection) x.openConnection();
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
             */

           /** String line = "";
            while(line != null) {
                line = reader.readLine();
                data.append(line);
            }

            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < data.length(); i++) {
               JSONObject obj = (JSONObject) arr.get(i);
            }

            return data.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data.toString();
            */

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void Fixtures(String id, RequestQueue requestQueue) {
        String url = "hdhhdhd" + id;

        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            try {
                                Log.d(TAG,"Here 2");
                                setContentView(R.layout.data);
                                TextView box = findViewById(R.id.display);
                                box.setText(response.toString());
                            } catch (Exception e) {
                                Log.d(TAG, "Here4");
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.d(TAG,error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**StringBuilder data = new StringBuilder();
        try {
            String url = "http://api.football-data.org/v1/teams/" + id + "/fixtures";
            URL x = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) x.openConnection();
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line = "";
            while(line != null) {
                line = reader.readLine();
                data.append(line);
            }

            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < data.length(); i++) {
                JSONObject obj = (JSONObject) arr.get(i);
            }

            return data.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data.toString();
        */
    }
}
