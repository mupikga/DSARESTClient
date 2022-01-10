package com.example.restexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restexample.API.API;
import com.example.restexample.API.Track;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditTrack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_track);

        Button back = (Button) findViewById(R.id.backId2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddTrack.class);
                startActivity(intent);
            }
        });

        Button delete = (Button) findViewById(R.id.deleteId);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteSong();
            }
        });

        Button edit = (Button) findViewById(R.id.editId);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSong();
            }
        });
    }

    public void deleteSong(){
        String id = "";

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        API gerritAPI = retrofit.create(API.class);
        Call<Void> call = gerritAPI.deleteTrack(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(EditTrack.this, "DELETED", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(EditTrack.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EditTrack.this, "ERROR", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void editSong(){}

}