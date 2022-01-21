package com.pwc.covid19.flow.network;

import com.pwc.covid19.flow.map.models.Covid19trackingResponseModel;
import com.pwc.covid19.flow.news.models.NewsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET("{Url}")
    Call<NewsResponseModel> getNews(@Path(value = "Url") String fullUrl,@Query("country") String country,
                                    @Query("category") String category,
                                    @Query("apiKey") String apiKey);



    @GET("api")
    Call<Covid19trackingResponseModel> covid19tracking(@Query("date_from") String date_from,
                                               @Query("date_to") String date_to);

    @GET()
    Call<CountryResponseModel> getCountries(@Url String url);
}
