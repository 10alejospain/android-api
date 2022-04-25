package com.etsisi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.etsisi.myapplication.models.Graph;
import com.etsisi.myapplication.rest.MadridService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://datos.madrid.es/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MadridService service = retrofit.create(MadridService.class);

        service.listRepos().enqueue(new Callback<Graph>() {
            @Override
            public void onResponse(Call<Graph> call, Response<Graph> response) {
                Log.e("EXITO", "OK");

                System.out.println(response.body().getDescription());

                }

            @Override
            public void onFailure(Call<Graph> call, Throwable t) {
                Log.e("-ERROR", t.getMessage());
            }

        });

    }
}