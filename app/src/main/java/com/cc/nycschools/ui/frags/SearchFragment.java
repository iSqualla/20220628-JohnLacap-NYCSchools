package com.cc.nycschools.ui.frags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.nycschools.R;
import com.cc.nycschools.databinding.FragmentSearchBinding;


public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(getLayoutInflater());

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String cityName = binding.tiCityName.getText().toString();
                NavDirections action =
                        DetailsFragmentDirections.actionSearchToList(cityName);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return binding.getRoot();
    }
}
