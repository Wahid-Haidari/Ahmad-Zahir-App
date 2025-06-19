package com.example.ahmadzahir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> songsList;
    LinearLayoutManager linearLayoutManager;
    SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        songsList = new ArrayList<>();
        songsList.add("افسوس که عشق پاک تو");
        songsList.add("او بانو بانو");
        songsList.add("ای پادشه ی خوبان");
        songsList.add("ای دزدیده چشم از آهو");
        songsList.add("ای دل ای دل");
        songsList.add("باز آمدی");
        songsList.add("بد دعایت کنم");
        songsList.add("پوشیده چون جان میروی");
        songsList.add("پیدا شد و پیدا شد");
        songsList.add("پیری رسید");
        songsList.add("ترا افسون چشمانم");
        songsList.add("چون درخت فروردین");
        songsList.add("حاشا که من");
        songsList.add("درخت یار");
        songsList.add("دلکم ای دلکم ای دلکم");
        songsList.add("رو سر بنه به بالین");
        songsList.add("ز سنگ نیست قلب من");
        songsList.add("سرمه کدی");
        songsList.add("عاشق رویت من");
        songsList.add("عاشق شده ای ای دل");
        songsList.add("فقط سوز دلم را");
        songsList.add("میروم خسته و افسرده و زار");
        songsList.add("میروی از من");
        songsList.add("هرگز کسی به روز من ناتوان");
        songsList.add("یاد روزگاران شیرین");

        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        songAdapter = new SongAdapter(songsList, this);
        recyclerView.setAdapter(songAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}