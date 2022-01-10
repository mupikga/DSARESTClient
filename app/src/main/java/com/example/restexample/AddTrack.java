package com.example.restexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restexample.API.API;
import com.example.restexample.API.Track;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddTrack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        Button back = (Button) findViewById(R.id.backId);
        Button add = (Button) findViewById(R.id.addId);

        TextView title = (TextView) findViewById(R.id.titleId);
        TextView singer = (TextView) findViewById(R.id.titleId);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleName = title.getText().toString();
                String singerName = singer.getText().toString();

                Gson gson = new GsonBuilder().setLenient().create();
                Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
                API gerritAPI = retrofit.create(API.class);
                Call<Track> call = gerritAPI.addTrack(new Track(titleName,singerName));
                call.enqueue(new Callback<Track>() {
                    @Override
                    public void onResponse(Call<Track> call, Response<Track> response) {
                        if(response.isSuccessful()){
                            Track t = response.body();
                            Log.i("REGISTER", "OK"+t.getTitle());
                        }
                        else{
                            Toast.makeText(AddTrack.this, "EL NOM D'USUARI INTRODUIT JA EXISTEIX, PORVA AMB UN ALTRE DIFERENT", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Track> call, Throwable t) {
                        Log.e("ADD", "ERROR",t);
                        Toast.makeText(AddTrack.this, "ERROR", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });


    }
}