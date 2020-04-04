package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_page extends AppCompatActivity {

    Button fyb, syb, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        fyb = findViewById(R.id.xfyb);
        syb= findViewById(R.id.xsyb);
        admin = findViewById(R.id.xadmin);

        fyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_fy_s = new Intent(home_page.this, FY_Sub.class);
                startActivity(i_fy_s);
            }
        });

        syb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_sy_dept = new Intent(home_page.this, SY_Dept.class);
                startActivity(i_sy_dept);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_admin = new Intent(home_page.this, Admin_Login.class);
                startActivity(i_admin);
            }
        });
    }
}
