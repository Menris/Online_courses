package com.project.ad.diploma_project.Categories;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.ad.diploma_project.R;
import com.project.ad.diploma_project.User_Information.UserInfo;
import com.project.ad.diploma_project.messages.ChatRoom;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static java.security.AccessController.getContext;


public class CoursesList extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ListView coursesList;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list_of_courses = new ArrayList<>();
    private TextView textView_courseTitle;
    private String intent_courseTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        coursesList = (ListView) findViewById(R.id.courses_listView);

        Intent intent = getIntent();
        String courseCategory = intent.getStringExtra("category");

        final ProgressDialog dialog = ProgressDialog.show(this, "", "Loading...",
                true);
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        }, 1000);



        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        ListView listCourses = (ListView) findViewById(R.id.courses_listView);
        Query myQuery = reference.child("courses").child("categories").child(courseCategory).child("courseName");
        FirebaseListAdapter<CourseInfo> adapter = new FirebaseListAdapter<CourseInfo>(this, CourseInfo.class, R.layout.list_items_img, myQuery) {
            @Override
            protected void populateView(View v, CourseInfo model, int position) {

                TextView courseTitle, courseDescription;
                ImageView imageView;
                courseTitle = (TextView) v.findViewById(R.id.textViewName);
                courseDescription = (TextView) v.findViewById(R.id.textViewDesc);
                imageView = (ImageView) v.findViewById(R.id.imageView_listCourses);

                Picasso.with(getApplicationContext()).load(model.getImageSrc()).resize(150,150).into(imageView);
                courseTitle.setText(model.getCourseTitle());
                courseDescription.setText(model.getCourseDescription());
                intent_courseTitle = model.getCourseTitle();
            }
        };
        listCourses.setAdapter(adapter);

        listCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Course Preview ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CoursePreview.class);
                intent.putExtra("courseTitle", intent_courseTitle );
                startActivity(intent);
            }
        });
    }


}
