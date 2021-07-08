package com.leobilha.covinfo.api;

import com.leobilha.covinfo.modelos.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<News> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<News> getNewsSearch(
            @Query("q") String keyword,
            @Query("language") String language,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<News> getCat(
            @Query("q") String q,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );

}