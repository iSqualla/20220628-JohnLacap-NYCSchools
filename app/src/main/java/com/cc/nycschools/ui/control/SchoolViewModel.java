package com.cc.nycschools.ui.control;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cc.nycschools.model.School;
import com.cc.nycschools.network.MainRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

public class SchoolViewModel extends ViewModel {
    @Inject
    MainRepositoryImpl repository;

    private LiveData<List<School>> schoolResponseLiveData;

    public SchoolViewModel() {
        getSchools();
    }

    public SchoolViewModel(LiveData<List<School>> schoolResponseLiveData) {
        this.schoolResponseLiveData = schoolResponseLiveData;
    }

    public void getSchools() {
        this.schoolResponseLiveData = repository.getSchools();
    }
    public void getSchool(String cityName) {
        this.schoolResponseLiveData = repository.getSchool(cityName);
    }

    public LiveData<List<School>> getSchoolResponseLiveData() {
        return schoolResponseLiveData;
    }
}
