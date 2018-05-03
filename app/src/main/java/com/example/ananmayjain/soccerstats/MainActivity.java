package com.example.ananmayjain.soccerstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void league_button(View v) {
        Intent start = new Intent(this, league_page.class);
        startActivity(start);
    }

    public void team_button(View v) {
        Intent start = new Intent(this, team_page.class);
        startActivity(start);
    }
}
