package com.example.ananmayjain.soccerstats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.Iterator;


public class team_page extends AppCompatActivity {
    public static RequestQueue requestQueue;
    private static final String TAG = "Final_Project:Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_page_team);
        requestQueue = Volley.newRequestQueue(this);

        final ImageButton Bayern = findViewById(R.id.Bayern);
        Bayern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Fixtures("117","Bayern Munich", requestQueue);
            }
        });

        final ImageButton Barca = findViewById(R.id.Barca);
        Barca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Fixtures("109","Barcelona", requestQueue);
            }
        });

        final ImageButton Real = findViewById(R.id.Real);
        Real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Fixtures("109","Real Madrid", requestQueue);
            }
        });

        final ImageButton Manunited = findViewById(R.id.Manunited);
        Manunited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Fixtures("62","Manchester United", requestQueue);
            }
        });

        final ImageButton Juve = findViewById(R.id.Juve);
        Juve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Fixtures( "79","Juventus", requestQueue);
            }
        });
    }

    public void Fixtures(final String id, final String name, RequestQueue requestQueue) {

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
                                    if (name.equals(response.getJSONObject(i)
                                            .get("team_name").toString())) {
                                        Iterator it = response.getJSONObject(i).keys();
                                        while (it.hasNext()) {
                                            String obj = (String)it.next();
                                            s += obj + "    " + response.getJSONObject(i).get(obj)
                                                    .toString() + "\n";
                                        }
                                        break;
                                    }
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
