package com.pwc.covid19.flow.map;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pwc.covid19.R;
import com.pwc.covid19.databinding.ActivityMapsBinding;
import com.pwc.covid19.flow.map.models.Country;
import com.pwc.covid19.flow.map.models.Covid19trackingResponseModel;
import com.pwc.covid19.flow.map.models.Dates;
import com.pwc.covid19.flow.network.APIClient;
import com.pwc.covid19.flow.network.ApiInterface;
import com.pwc.covid19.flow.news.models.CountryCoronaNewsActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback , GoogleMap.OnMarkerClickListener {

    public static final String EXTRA_COUNTRY = "extra.country";
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private ApiInterface apiInterface;
    private Geocoder geocoder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = APIClient.getClient().create(ApiInterface.class);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getCovid19TrackingInfo();
    }

    private void getCovid19TrackingInfo() {
        Call<Covid19trackingResponseModel> call = apiInterface.covid19tracking("2022-01-15", "2022-01-15");
        call.enqueue(new Callback<Covid19trackingResponseModel>() {
            @Override
            public void onResponse(Call<Covid19trackingResponseModel> call, Response<Covid19trackingResponseModel> response) {
                Map<String, Dates> map = response.body().getDates();
                for (Map.Entry<String, Dates> entry : map.entrySet()) {
                    Map<String, Country> map2 = entry.getValue().getCountries();
                    for (Map.Entry<String, Country> country : map2.entrySet()) {
                        try {
                            List<Address> fromLocationName = geocoder.getFromLocationName(country.getValue().getName(), 1);

                                    LatLng latLng = new LatLng(  fromLocationName.get(0).getLatitude(),  fromLocationName.get(0).getLongitude());
                            mMap.addMarker(new MarkerOptions().position(latLng).title("Confirmed Cases: "+country.getValue().getTodayConfirmed()+"\n"+
                            "Today Deaths:"+country.getValue().getTodayDeaths()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }


            }

            @Override
            public void onFailure(Call<Covid19trackingResponseModel> call, Throwable t) {
                call.cancel();
            }
        });

    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        LatLng location = marker.getPosition();
        showNewsScreen(getCountryName(location.latitude,(location.longitude )));
        return false;
    }

    private void showNewsScreen(String country ) {
        Intent intent = new Intent(MapsActivity.this, CountryCoronaNewsActivity.class);
        intent.putExtra(EXTRA_COUNTRY,country);
        startActivity(intent);
    }

    public String getCountryName(double lat, double lng) {
        String countryName = null;
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
             countryName = addresses.get(0).getCountryName();
            return countryName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryName;
    }
}