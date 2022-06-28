package com.cc.nycschools.network;

import androidx.lifecycle.LiveData;

import com.cc.nycschools.model.School;
import com.cc.nycschools.model.Scores;

import java.util.List;

import javax.inject.Inject;

public interface MainRepository {

    LiveData<List<Scores>> getScores(String dbn);
    LiveData<List<School>> getSchool(String name);
    LiveData<List<School>> getSchools();

}