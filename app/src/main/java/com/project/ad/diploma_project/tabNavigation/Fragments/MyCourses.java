package com.project.ad.diploma_project.tabNavigation.Fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.project.ad.diploma_project.R;
import com.project.ad.diploma_project.tabNavigation.CustomList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCourses extends Fragment {
    public MyCourses() {
        // Required empty public constructor
    }
    private ListView listView;


    private String desc[] = {
            "The Powerful Hypter Text Markup Language 5",
            "Cascading Style Sheets",
            "Code with Java Script",
            "Manage your content with Wordpress"
    };


    private String names[] = {
            "HTML",
            "CSS",
            "Java Script",
            "Wordpress"
    };

    private Integer imageid[] = {
            R.drawable.html,
            R.drawable.css,
            R.drawable.js,
            R.drawable.wp
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_courses, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        CustomList customList = new CustomList(getActivity(), names, desc, imageid);
        listView = (ListView) getActivity().findViewById(R.id.listView_images);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext().getApplicationContext(),"You Clicked "+names[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
