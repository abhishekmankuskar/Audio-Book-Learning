package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub_Comp extends AppCompatActivity {

    Button oop, coa, dsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__comp);

        oop = findViewById(R.id.xoop);
        coa = findViewById(R.id.xcoa);
        dsa = findViewById(R.id.xdsa);

        oop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_oop = new Intent(Sub_Comp.this, Topic_OOP.class);
                startActivity(i_oop);
            }
        });

        coa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_coa = new Intent(Sub_Comp.this, Topic_COA.class);
                startActivity(i_coa);
            }
        });

        dsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_dsa = new Intent(Sub_Comp.this, Topic_DSA.class);
                startActivity(i_dsa);
            }
        });
    }
}
