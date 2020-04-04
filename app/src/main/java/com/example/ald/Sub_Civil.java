package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub_Civil extends AppCompatActivity {

    Button lv, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__civil);

        lv = findViewById(R.id.xlv);
        c = findViewById(R.id.xc);

        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_lv = new Intent(Sub_Civil.this, Work_In_Progress.class);
                startActivity(i_lv);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_c = new Intent(Sub_Civil.this, Work_In_Progress.class);
                startActivity(i_c);
            }
        });
    }
}
