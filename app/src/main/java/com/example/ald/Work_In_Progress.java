package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Work_In_Progress extends AppCompatActivity {

    TextView wip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__in__progress);

        wip = findViewById(R.id.wip);
    }
}
