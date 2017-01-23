package com.project.ad.diploma_project.Categories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.ad.diploma_project.R;
import com.project.ad.diploma_project.messages.Messages;
import com.project.ad.diploma_project.tabNavigation.Fragments.MyCourses;
import com.project.ad.diploma_project.tabNavigation.Profile;

import java.util.HashMap;
import java.util.Map;

public class CoursePreview extends AppCompatActivity implements View.OnClickListener{

    private Button button_subscribe;

    private DatabaseReference databaseReference;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_preview);

        databaseReference = FirebaseDatabase.getInstance().getReference();


        button_subscribe = (Button) findViewById(R.id.button_subscribe);
        button_subscribe.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == button_subscribe){
            subscribe_on_course();
        }
    }

    private void subscribe_on_course() {
        Intent intent = getIntent();
        String courseTitle = intent.getStringExtra("courseTitle");

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        DatabaseReference ref = databaseReference.child("chatRooms").child(user.getUid()).child(courseTitle);


        intent = new Intent(this,Profile.class);
        intent.putExtra("courseTitle1", courseTitle );
        startActivity(intent);
    }
}
