package com.vacreall.healthopt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyRecordsFragment extends Fragment {
    private View rootView;
    public static final String PREFERENCE= "preference";
    private SharedPreferences mSharedPreferences;
    Button fetchrecords;

    public static MyRecordsFragment newInstance() {
        MyRecordsFragment fragment = new MyRecordsFragment();
        return fragment;
    }

    public MyRecordsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_my_records, container, false);
        fetchrecords = (Button) rootView.findViewById(R.id.bt_fetchrecords);
        fetchrecords.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getContext(), ViewMyrecords.class);
                startActivity(i);
            }
        });

        //mSharedPreferences = rootView.getSharedPreferences(PREFERENCE, getActivity().MODE_PRIVATE);
        //String restoredText = sharedpreferences.getString("text", null);
        return rootView;

    }

}
