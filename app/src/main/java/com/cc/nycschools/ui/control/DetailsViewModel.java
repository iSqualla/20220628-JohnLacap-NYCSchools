package com.cc.nycschools.ui.control;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cc.nycschools.model.Scores;
import com.cc.nycschools.network.MainRepository;
import com.cc.nycschools.network.MainRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

public class DetailsViewModel extends AndroidViewModel {
    @Inject
    MainRepositoryImpl repository;
    private LiveData<List<Scores>> scoresResponseLiveData;

    DetailsViewModel(@NonNull Application application){
        super(application);
    }

    public void getScores(String dbn) {
        this.scoresResponseLiveData = repository.getScores(dbn);
    }


    public LiveData<List<Scores>> getSchoolResponseLiveData() {
        return scoresResponseLiveData;
    }

}
