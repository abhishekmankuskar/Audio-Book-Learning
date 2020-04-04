package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FY_Sub extends AppCompatActivity {

    Button chemb, phyb, civilb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fy__sub);

        chemb = findViewById(R.id.xchemb);
        phyb = findViewById(R.id.xphyb);
        civilb = findViewById(R.id.xcivilb);


        chemb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_chem = new Intent(FY_Sub.this, Sub_Chem.class);
                startActivity(i_chem);
            }
        });

        phyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_phy = new Intent(FY_Sub.this, Sub_Phy.class);
                startActivity(i_phy);
            }
        });

        civilb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_civil = new Intent(FY_Sub.this, Sub_Civil.class);
                startActivity(i_civil);
            }
        });

    }
}
