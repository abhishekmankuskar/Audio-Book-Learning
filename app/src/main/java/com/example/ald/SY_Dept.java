package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SY_Dept extends AppCompatActivity {

    Button comp, mech, etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sy__dept);

        comp = findViewById(R.id.xcomp);
        mech = findViewById(R.id.xmech);
        etc = findViewById(R.id.xetc);

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_comp = new Intent(SY_Dept.this, Sub_Comp.class);
                startActivity(i_comp);
            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_mech = new Intent(SY_Dept.this, Work_In_Progress.class);
                startActivity(i_mech);
            }
        });

        etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_etc = new Intent(SY_Dept.this, Work_In_Progress.class);
                startActivity(i_etc);
            }
        });
    }
}
