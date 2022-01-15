package com.pwc.covid19.flow.news.models;

import static com.pwc.covid19.flow.map.MapsActivity.EXTRA_COUNTRY;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pwc.covid19.R;
import com.pwc.covid19.flow.network.APIClient;
import com.pwc.covid19.flow.network.ApiInterface;
import com.pwc.covid19.flow.network.CountryResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryCoronaNewsActivity extends AppCompatActivity {

    private String countryName = "";
    private ApiInterface apiInterface;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_corona_news);
        apiInterface = APIClient.getClient().create(ApiInterface.class);

        countryName = getIntent().getStringExtra(EXTRA_COUNTRY);
        getCountryCode();
        setupRecyclerView();
    }

    private void getCountryCode() {
        Call<CountryResponseModel> call = apiInterface.getCountries("https://restcountries.com/v3.1/name/" + countryName + "?fullText=true");
        call.enqueue(new Callback<CountryResponseModel>() {
            @Override
            public void onResponse(Call<CountryResponseModel> call, Response<CountryResponseModel> response) {
                getNewsItems(response.body().getCca2());
            }
            @Override
            public void onFailure(Call<CountryResponseModel> call, Throwable t) {
                call.cancel();
            }
        });
    }

    private void getNewsItems(String countryCode) {
        Call<NewsResponseModel> call = apiInterface.getNews(countryCode, "health", "32c639db0d774ef4b9d6c9ef09137b0f");
        call.enqueue(new Callback<NewsResponseModel>() {
            @Override
            public void onResponse(Call<NewsResponseModel> call, Response<NewsResponseModel> response) {
                List<Article> articles = response.body().getArticles();
                adapter.setItems(MapNewsItems(articles));
            }

            @Override
            public void onFailure(Call<NewsResponseModel> call, Throwable t) {
                call.cancel();
            }
        });
    }

    private ArrayList<NewsItemUiModel> MapNewsItems(List<Article> articles) {
        ArrayList<NewsItemUiModel> itemUiModels = new ArrayList<>();
        for(Article article :articles){
            itemUiModels.add(new NewsItemUiModel(article.getTitle(), article.getPublishedAt()
            , article.getUrlToImage(), article.getDescription()));
        }
        return itemUiModels;
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new NewsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}