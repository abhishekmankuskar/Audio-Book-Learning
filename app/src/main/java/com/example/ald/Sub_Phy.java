package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub_Phy extends AppCompatActivity {

    Button plz, lssr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__phy);

        plz = findViewById(R.id.xplz);
        lssr = findViewById(R.id.xlssr);

        plz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_plz = new Intent(Sub_Phy.this, Work_In_Progress.class);
                startActivity(i_plz);
            }
        });

        lssr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_lssr = new Intent(Sub_Phy.this, Work_In_Progress.class);
                startActivity(i_lssr);
            }
        });

    }
}
