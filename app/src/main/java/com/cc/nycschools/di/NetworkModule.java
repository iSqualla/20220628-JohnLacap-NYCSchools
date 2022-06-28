package com.cc.nycschools.di;

import com.cc.nycschools.Utils;
import com.cc.nycschools.network.MainRepositoryImpl;
import com.cc.nycschools.network.RetroAPIService;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient providesOKHttp(){
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okhttp){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Utils.BASE_URL)
                .client(okhttp)
                .build();
    }

    @Provides
    RetroAPIService providesRetroAPIService(Retrofit retrofit) {
        return retrofit.create(RetroAPIService.class);
    }

    @Provides
    @Singleton
    MainRepositoryImpl providesRepository(RetroAPIService apiService){
        return new MainRepositoryImpl();
    }

}
