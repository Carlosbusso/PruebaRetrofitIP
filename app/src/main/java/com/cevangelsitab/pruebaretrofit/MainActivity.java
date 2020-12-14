package com.cevangelsitab.pruebaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.JsonObject;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    String alternatives="true";
    String geometries="polyline6";
    String overview="full";
    String steps="true";
    String bearings="90,90;0,0";
    String continue_straight="true";
    String annotations="congestion,distance";
    String language="es";
    String roundabout_exits="true";
    String voice_instructions="true";
    String banner_instructions="true";
    String voice_units="metric";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                // Change with IP address
                .baseUrl("http://XXX.XXX.XXX.XXX/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        GetApi service = retrofit.create(GetApi.class);
        Call<JsonObject> userCall = service.getPosts(alternatives,geometries,overview,steps,bearings,continue_straight,annotations,language,roundabout_exits,voice_instructions,banner_instructions,voice_units);
        userCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if(response.isSuccessful()) {

                    JsonObject listaDatos = response.body();
                    Log.i("Response ", "to String :" + response.toString());
                    Log.i("Body ", "to String :" + listaDatos.toString());
                }

                else {
                    Log.e("response", " not successful : " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                if (t instanceof IOException) {

                    Toast.makeText(MainActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(MainActivity.this, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
            }
        });

    }
}