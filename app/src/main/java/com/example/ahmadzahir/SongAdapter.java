package com.example.ahmadzahir;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter <SongAdapter.SongViewHolder> {
    ArrayList<String> allSongsArrayList;
    Context context;


    public SongAdapter(ArrayList<String> allSongsArrayList, Context context){
        this.context = context;
        this.allSongsArrayList = allSongsArrayList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.all_songs, parent, false);
        SongViewHolder songViewHolder = new SongViewHolder(view,context);
        return songViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        final String currentSong = allSongsArrayList.get(position);
        holder.textView.setText(currentSong);
        holder.setCurrentSong(currentSong);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,currentSong,Toast.LENGTH_LONG).show();
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return allSongsArrayList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        SongClickListener songClickListener;

        public SongViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_song);
            songClickListener = new SongClickListener(context);
            itemView.setOnClickListener(songClickListener);
        }

        public void setCurrentSong(String currentSong){
            songClickListener.setCurrentSong(currentSong);
        }


        private class SongClickListener implements View.OnClickListener{

            private String currentSong;
            private Context context;

            public SongClickListener(Context context){
                this.context = context;
            }

            public void setCurrentSong(String song){
                this.currentSong = song;

            }


            @Override
            public void onClick(View v) {
                if(currentSong!=null){

                    Toast.makeText(context, currentSong,Toast.LENGTH_LONG).show();

                }
            }
        }
    }


}
