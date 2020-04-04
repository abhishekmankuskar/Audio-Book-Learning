package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topic_DSA extends AppCompatActivity {

    Button ll, sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic__ds);

        ll = findViewById(R.id.xll);
        sal = findViewById(R.id.xsal);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_ll = new Intent(Topic_DSA.this, Work_In_Progress.class);
                startActivity(i_ll);
            }
        });

        sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_sal = new Intent(Topic_DSA.this, Work_In_Progress.class);
                startActivity(i_sal);
            }
        });

    }
}