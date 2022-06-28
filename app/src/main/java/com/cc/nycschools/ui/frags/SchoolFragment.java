package com.cc.nycschools.ui.frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.nycschools.R;
import com.cc.nycschools.databinding.FragmentSchoolBinding;
import com.cc.nycschools.model.School;
import com.cc.nycschools.ui.control.SchoolAdapter;
import com.cc.nycschools.ui.control.SchoolViewModel;

import java.util.ArrayList;
import java.util.List;

public class SchoolFragment extends Fragment {

    private FragmentSchoolBinding binding;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<School> schoolArrayList = new ArrayList<>();
    SchoolViewModel schoolViewModel;
    private SchoolAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSchoolBinding.inflate(getLayoutInflater());

        init();
        getSchools();

        return binding.getRoot();
    }

    private void getSchools() {

        schoolViewModel.getSchoolResponseLiveData().observe(getViewLifecycleOwner(), schoolResponse -> {

            if (schoolResponse != null && !schoolResponse.isEmpty()) {
                List<School> schoolList = schoolResponse;
                schoolArrayList.addAll(schoolList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void openDetails(School school, View view) {
        NavDirections action =
                SchoolFragmentDirections.actionListToSchoolDetails(school);
        Bundle bundle = new Bundle();

        Navigation.findNavController(view).navigate(R.id.action_list_to_school_details, bundle);
    }

    private void init() {
        recyclerView = binding.rvSchools;
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new SchoolAdapter(getActivity(), schoolArrayList, this, this::openDetails);

        recyclerView.setAdapter(adapter);
        schoolViewModel = new ViewModelProvider(requireActivity()).get(SchoolViewModel.class);
        schoolViewModel.getSchools();
    }
}