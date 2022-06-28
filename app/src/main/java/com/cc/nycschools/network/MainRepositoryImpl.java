package com.cc.nycschools.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cc.nycschools.model.School;
import com.cc.nycschools.model.Scores;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainRepositoryImpl implements MainRepository{
    RetroAPIService apiRequest;

    @Inject
    Retrofit retrofit;

    public MainRepositoryImpl() {
        apiRequest = retrofit.create(RetroAPIService.class);
    }

    public LiveData<List<School>> getSchools() {
        final MutableLiveData<List<School>> data = new MutableLiveData<>();
        apiRequest.getSchools().enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                Log.d("state", response.body().toString());
                if (response.body() != null)
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d("state", "failed");
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<List<School>> getSchool(String cityName) {
        final MutableLiveData<List<School>> data = new MutableLiveData<>();
        apiRequest.getSchool(cityName).enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                Log.d("state", response.body().toString());
                if (response.body() != null)
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d("state", "failed");
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<List<Scores>> getScores(String dbn) {
        final MutableLiveData<List<Scores>> data = new MutableLiveData<>();
        apiRequest.getScores(dbn).enqueue(new Callback<List<Scores>>() {

            @Override
            public void onResponse(Call<List<Scores>> call, Response<List<Scores>> response) {
                Log.d("state", response.body().toString());
                if (response.body() != null)
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Scores>> call, Throwable t) {
                Log.d("state", "failed");
                data.setValue(null);
            }
        });
        return data;
    }
}
