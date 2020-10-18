package com.example.ahmadzahir;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PlayedSongActivity extends AppCompatActivity {
boolean isPlaying = true;
    Button button;
    TextView textView;
    String song = AllSongsActivity.song;
    MediaPlayer mediaPlayer = AllSongsActivity.mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_played_song);

        button = findViewById(R.id.playButton);
        textView = findViewById(R.id.lyricsTextView);
        textView.setText(AllSongsActivity.song);

        final SeekBar scrubSeekBar = findViewById(R.id.scrubSeekBar);
        scrubSeekBar.setMax(mediaPlayer.getDuration());



        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0, 2000 );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    mediaPlayer.pause();
                    button.setText("play");
                    isPlaying = false;
                }
                else if(!isPlaying){
                    mediaPlayer.start();
                    isPlaying = true;
                    button.setText("pause");
                }

            }
        });

    }

    public void setLyrics(){
    }

    public void next(View view){
        AllSongsActivity.song = AllSongsActivity.songsList.get(AllSongsActivity.songsList.indexOf(song));
        AllSongsActivity.next();
    }

}