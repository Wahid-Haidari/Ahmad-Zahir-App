package com.example.ahmadzahir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button songsButton;
    static boolean comeBack = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (comeBack) {
            AllSongsActivity.mediaPlayer.pause();
        }


        songsButton = findViewById(R.id.btn_allSongs);
        songsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySongs();
            }
        });
    }

    public void openActivitySongs(){
        Intent intent = new Intent(this, AllSongsActivity.class);
        startActivity(intent);
    }
}