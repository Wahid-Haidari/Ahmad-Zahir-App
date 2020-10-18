package com.example.ahmadzahir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class AllSongsActivity extends AppCompatActivity {
    static ArrayList<String> songsList;
    static MediaPlayer mediaPlayer;
    //Song is the song that will be played.
    static String song = "";
    //The current song stores the song that is already played.
    String currentSong = "";
    boolean songIsPlayed = false;
    static boolean nextButtonIsPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);

        ListView songsListView = findViewById(R.id.allSongsListView);
        songsList = new ArrayList<>(asList(
                "از آن روز که پیمان با تو بستم",
                "افسوس که عشق پاک تو",
                "اگر ای آسمان", "او بانو بانو",
                "ای بلبل شوریده",
                "ای پادشه ی خوبان",
                "ای دزدیده چشم از آهو",
                "ای دل ای دل",
                "ای سرود واپسینم",
                "باز آمدی",
                "بد دعایت کنم",
                "بگذرد بگذرد با احمد ولی",
                "بهار بهار",
                "بیا که بریم به مزار",
                "بیایید که گلزار دمیده است",
                "پوشیده چون جان میروی",
                "پیدا شد و پیدا شد",
                "پیری رسید",
                "ترا افسون چشمانم",
                "حاشا که من",
                "درخت فروردین",
                "درخت یار",
                "روز و شبم الم با ناشناس",
                "همه یارانم مجلسی",
                "مره مره می بده",
                "میهن ای میهن",
                "یاد روزگاران شیرین"
));

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
        songsList.add("همه یارانم");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, songsList);
        songsListView.setAdapter(arrayAdapter);

        songsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (songsList.get(position)) {
                    case "از آن روز که پیمان با تو بستم":
                        song = "az_an_roz_ke_paiman";
                        break;
                    case "افسوس که عشق پاک تو":
                        song = "afsos_ke_eshqe";
                        break;
                    case "اگر ای آسمان":
                        song = "agar_ai_asoman";
                        break;

                    case "او بانو بانو":
                        song = "o_bano_bano";
                        break;
                    case "ای پادشه ی خوبان":
                        song = "ai_padeshae_khoban";
                        break;
                    case "ای بلبل شوریده":
                        song = "ai_bulbule_shorida";
                        break;
                    case "ای دزدیده چشم از آهو":
                        song = "ai_duzdida_chashm";
                        break;
                    case "ای دل ای دل":
                        song = "ai_dil_ai_dil";
                        break;
                    case "ای سرود واپسینم":
                        song = "ai_surude_wapasinam";
                        break;
                    case "باز آمدی":
                        song = "baz_amadi";
                        break;
                    case "بد دعایت کنم":
                        song = "badoait_konom";
                        break;
                    case "بگذرد بگذرد با احمد ولی":
                        song = "bigzarad_bigzarad_ahmadwali";
                        break;
                    case "بهار بهار":
                        song = "bahar_bahar";
                        break;

                    case "بیا که بریم به مزار":
                        song = "bia_ke_borem_ba_mazar";
                        break;
                    case "بیایید که گلزار دمیده است":
                        song = "byayed_ke_gulzar";
                        break;
                    case "پوشیده چون جان میروی":
                        song = "poshida_chun_jan";
                        break;

                    case "پیدا شد و پیدا شد":
                        song = "paida_shodo_paida_shod";
                        break;

                    case "پیری رسید":
                        song = "piri_rasid";
                        break;

                    case "ترا افسون چشمانم":
                        song = "tura_afsune_chashmanam";
                        break;
                    case "حاشا که من":
                        song = "hasha_ke_man";
                        break;

                    case "درخت فروردین":
                        song = "darakhte_farwardin";
                        break;
                    case "درخت یار":
                        song = "darakhte_yar";
                        break;

                    case "روز و شبم الم با ناشناس":
                        song = "rozo_shabam_alam_nashinas";
                        break;
                    case "همه یارانم مجلسی":
                        song = "hama_yaranam_majlisi";
                        break;

                    case "مره مره می بده":
                        song = "mara_mara_mai_bede";
                        break;
                    case "میهن ای میهن":
                        song = "maihan_ai_maihan";
                        break;

                    case "یاد روزگاران شیرین":
                       song = "yade_rozogare_shirin";
                       break;
                    default:
                        song = "yade_rozogare_shirin";
                        break;
                }


                play(song);
                openActivityPlayedSong();
            }
        });


    }
//Check if a song is already played stop it and create and new media player with a new song
    public void play(String song){


        if(songIsPlayed) {
                //Check if the song is already played so that it does not start over.

            if(!currentSong.equals(song)){
                mediaPlayer.pause();
                songIsPlayed = false;
                play(song);
            }

        }

            else{
                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(song, "raw", getPackageName()));
                mediaPlayer.start();
                currentSong = song;
                songIsPlayed =true;
            }


    }

    public void openActivityPlayedSong(){
        Intent intent = new Intent(this, PlayedSongActivity.class);
        startActivity(intent);
    }

    public static void next(){
        mediaPlayer.pause();
        song = songsList.get(songsList.indexOf(song));

            //song = songsList.get(songsList.indexOf(song)+1);

    }




}