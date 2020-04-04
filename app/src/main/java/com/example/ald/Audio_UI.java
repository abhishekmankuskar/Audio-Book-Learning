package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Audio_UI extends AppCompatActivity {

    ImageView Stop, Play, Pause;
    DBHandler dbh;
    MediaPlayer mediaPlayer;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_ui);

        dbh = new DBHandler(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.von);

        Stop = findViewById(R.id.stop);
        Play = findViewById(R.id.play);
        Pause = findViewById(R.id.pause);

        final String topic_aui = getIntent().getStringExtra("topic");


        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dbh.checkempty()) {
                    Toast.makeText(Audio_UI.this, "There is no audio available", Toast.LENGTH_LONG).show();
                }
                else {
                    mediaPlayer.start();
                }
            }
        });

        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
    }
}
