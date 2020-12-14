package com.cevangelsitab.pruebaretrofit;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetApi {

    // Change token
    @GET("navigate/directions/v5/gh/cycling/-77.089097,-12.07816;-77.090203,-12.079318?access_token=pk.af9337af-73b9-4270-b0a2-XXXX")
    Call<JsonObject> getPosts(

            @Query("alternatives") String alternatives,
            @Query("geometries") String geometries,
            @Query("overview") String overview,
            @Query("steps") String steps,
            @Query("bearings") String bearings,
            @Query("continue_straight") String continue_straight,
            @Query("annotations") String annotations,
            @Query("language") String language,
            @Query("roundabout_exits") String roundabout_exits,
            @Query("voice_instructions") String voice_instructions,
            @Query("banner_instructions") String banner_instructions,
            @Query("voice_units") String voice_units

    );

}