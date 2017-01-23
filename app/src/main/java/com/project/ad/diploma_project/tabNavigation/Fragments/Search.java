package com.project.ad.diploma_project.tabNavigation.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.ad.diploma_project.Categories.CoursesList;
import com.project.ad.diploma_project.R;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment implements View.OnClickListener{


    public Search() {
        // Required empty public constructor
    }
    private Button button_CS;
    private Button button_Business;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        button_CS = (Button) v.findViewById(R.id.cat_CS);
        button_Business = (Button) v.findViewById(R.id.cat_business);
        button_CS.setOnClickListener(this);
        button_Business.setOnClickListener(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onButtonClick(String categoryName){
        Intent intent = new Intent(getActivity(),CoursesList.class);
        intent.putExtra("category",categoryName);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cat_CS:
                onButtonClick("computerScience");
                break;
            case R.id.cat_business:
                onButtonClick("business");
                break;
        }
    }
}
