package com.example.restexample.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    public static final String BASE_URL = "http://localhost:8080/dsaApp/";

    @GET("tracks")
    Call<List<Track>> getTracks();

    @POST("tracks")
    Call<Track> addTrack(@Body Track track);

}
