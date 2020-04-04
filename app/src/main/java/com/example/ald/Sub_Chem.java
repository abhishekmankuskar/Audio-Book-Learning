package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub_Chem extends AppCompatActivity {

    Button sas, bcb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__chem);

        sas = findViewById(R.id.xsas);
        bcb = findViewById(R.id.xbc);

        sas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_sas = new Intent(Sub_Chem.this, Work_In_Progress.class);
                startActivity(i_sas);
            }
        });

        bcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_bcb = new Intent(Sub_Chem.this, Work_In_Progress.class);
                startActivity(i_bcb);
            }
        });
    }
}
