package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topic_OOP extends AppCompatActivity {

    Button bsc, inh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic__oop);

        bsc = findViewById(R.id.xb);
        inh = findViewById(R.id.xinh);

        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_bsc = new Intent(Topic_OOP.this, Work_In_Progress.class);
                startActivity(i_bsc);
            }
        });

        inh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_inh = new Intent(Topic_OOP.this, Work_In_Progress.class);
                startActivity(i_inh);
            }
        });
    }
}
