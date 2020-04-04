package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topic_COA extends AppCompatActivity {

    Button vna, cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic__co);

        vna = findViewById(R.id.xvna);
        cache = findViewById(R.id.xcache);

        vna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_vna = new Intent(Topic_COA.this, Audio_UI.class);
                i_vna.putExtra("topic", "VNA");
                startActivity(i_vna);
            }
        });

        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_cache = new Intent(Topic_COA.this, Work_In_Progress.class);
                startActivity(i_cache);
            }
        });
    }
}
