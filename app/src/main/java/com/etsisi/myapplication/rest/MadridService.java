package com.etsisi.myapplication.rest;

import com.etsisi.myapplication.models.Graph;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MadridService {

    @GET("egob/catalogo/206974-0-agenda-eventos-culturales-100.json")
    Call<Graph> listRepos();
}
