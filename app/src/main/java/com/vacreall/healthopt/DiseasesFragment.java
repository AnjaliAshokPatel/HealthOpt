package com.vacreall.healthopt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiseasesFragment extends Fragment {

    ArrayList diseasNames = new ArrayList<>(Arrays.asList("AH1N1 Flu","Anemia","Appendicitis","Asthama","Cold", "Constipation" ,"Dehydration"));
    ArrayList symptomsNo = new ArrayList<>(Arrays.asList("Symptoms : 9","Symptoms : 4","Symptoms : 5", "Symptoms : 7","Symptoms : 9","Symptoms : 13","Symptoms : 10"));
    ArrayList category = new ArrayList<>(Arrays.asList("Category : Infectious Diseases","Category : Hematologic Diseases","Category : Gastrointestinal Diseases","Category : Respiratory Diseases","Category : Infectious Diseases","Category: Others","Category: Others"));
   // ArrayList specialist = new ArrayList<>(Arrays.asList("Specialist : Dr. Mukharji","Specialist : Dr. Mukharji"));
    ArrayList description = new ArrayList<>(Arrays.asList("The Symptoms of influenza A/H1N1 are similar to those of seasonal flue, such as sudden fever","The term Anemia describes the number of red blood cells is low","The main symptom is abdominal pain.","Asthama is a chronic disease charaterized by episode of airflow obstruction.","It causes runny nose, nasal congestion","A person has three bowel movements","Loss of body fluids, especially water"));
    private SeekBar simpleSeekBar;

    public static DiseasesFragment newInstance() {
        DiseasesFragment fragment = new DiseasesFragment();
        return fragment;
    }

    public DiseasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_diseases, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.diseas_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DiseasAdapter diseasAdapter = new DiseasAdapter(getActivity().getBaseContext(),diseasNames,symptomsNo,category,description);
        recyclerView.setAdapter(diseasAdapter);





        return rootView;
    }

}
