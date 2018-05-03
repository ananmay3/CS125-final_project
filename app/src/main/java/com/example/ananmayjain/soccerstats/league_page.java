package com.example.ananmayjain.soccerstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class league_page extends AppCompatActivity {
    public static RequestQueue requestQueue;
    private static final String TAG = "Final_Project:Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_page_league);
        requestQueue = Volley.newRequestQueue(this);

        final ImageButton premierLeague = findViewById(R.id.premierLeague);
        premierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Standings("62", requestQueue);
            }
        });

        final ImageButton laLiga = findViewById(R.id.laLiga);
        laLiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Standings("109", requestQueue);
            }
        });

        final ImageButton Bundesliga = findViewById(R.id.Bundesliga);
        Bundesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Standings("117", requestQueue);
            }
        });

        final ImageButton serieA = findViewById(R.id.serieA);
        serieA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Standings("79", requestQueue);
            }
        });

        final ImageButton Ligue1 = findViewById(R.id.Ligue1);
        Ligue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Standings("127", requestQueue);
            }
        });

    }

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
                                String s = "";
                                for (int i = 0; i < response.length(); i++) {
                                    s += response.getJSONObject(i).get("team_name").toString()
                                            + "\n" + response.getJSONObject(i)
                                            .get("overall_league_position").toString() + "\n\n";
                                }
                                box.setText(s);
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
}
