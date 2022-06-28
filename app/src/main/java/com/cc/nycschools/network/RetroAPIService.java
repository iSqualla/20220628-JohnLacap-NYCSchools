package com.cc.nycschools.network;

import androidx.lifecycle.LiveData;

import com.cc.nycschools.model.School;
import com.cc.nycschools.model.Scores;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroAPIService {

    @GET("resource/s3k6-pzi2.json")
    Call<List<School>> getSchools();

    @GET("resource/s3k6-pzi2.json")
    Call<List<School>> getSchool(
            @Query("city") String cityName
    );

    @GET("resource/f9bf-2cp4.json")
    Call<List<Scores>> getScores(
            @Query("dbn") String dbn
    );
}