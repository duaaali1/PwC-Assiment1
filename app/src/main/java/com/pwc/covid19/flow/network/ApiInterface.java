package com.pwc.covid19.flow.network;

import com.pwc.covid19.flow.map.models.Covid19trackingResponseModel;
import com.pwc.covid19.flow.news.models.NewsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET("https://newsapi.org/v2/top-headlines")
    Call<NewsResponseModel> getNews(@Query("country") String country,
                                    @Query("category") String category,
                                    @Query("apiKey") String apiKey);



    @GET("https://api.covid19tracking.narrativa.com/api")
    Call<Covid19trackingResponseModel> covid19tracking(@Query("date_from") String date_from,
                                               @Query("date_to") String date_to);

    @GET()
    Call<CountryResponseModel> getCountries(@Url String url);
}
