package com.cc.nycschools.ui.frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.nycschools.R;
import com.cc.nycschools.databinding.FragmentDetailsBinding;
import com.cc.nycschools.model.School;
import com.cc.nycschools.ui.control.DetailsViewModel;


public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;
    DetailsViewModel detailsViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(getLayoutInflater());

        init();
        getScores();

        return binding.getRoot();
    }

    private void getScores() {

        detailsViewModel.getSchoolResponseLiveData().observe(getViewLifecycleOwner(), scoresResponse -> {

            if(scoresResponse != null && !scoresResponse.isEmpty())
            {
                binding.tvReadScore.setText(scoresResponse.get(0).getSatCriticalReadingAvgScore());
                binding.tvWriteScore.setText(scoresResponse.get(0).getSatWritingAvgScore());
                binding.tvMathScore.setText(scoresResponse.get(0).getSatMathAvgScore());
            }
        });
    }

    private void init() {
        School school = (School) getArguments().getSerializable("school");
        binding.tvSchoolName.setText(school.getSchoolName());
        binding.tvLocation.setText(school.getLocation());
        binding.tvPhone.setText(school.getPhoneNumber());
        binding.tvEmail.setText(school.getSchoolEmail());
        binding.tvOverview.setText(school.getOverviewParagraph());
        detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
        detailsViewModel.getScores(school.getDbn());
    }

}
