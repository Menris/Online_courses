package com.project.ad.diploma_project.User_Information;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.ad.diploma_project.MainActivity;
import com.project.ad.diploma_project.tabNavigation.Profile;
import com.project.ad.diploma_project.R;

public class UserInfo extends AppCompatActivity implements  View.OnClickListener{

    public EditText userName;
    public EditText userLastName;
    private RadioButton radioStudent;
    private RadioButton radioTeacher;
    private DatabaseReference databaseReference;
    private Button addUser;
    private Boolean user_check;
    private FirebaseAuth firebaseAuth;

    public String group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, MainActivity.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

        addUser = (Button) findViewById(R.id.button_createUser);
        radioStudent = (RadioButton) findViewById(R.id.radioButton_student);
        radioTeacher = (RadioButton) findViewById(R.id.radioButton_teacher);
        userLastName = (EditText) findViewById(R.id.input_lastName);
        userName = (EditText) findViewById(R.id.input_firstName);
        user_check = true;

        addUser.setOnClickListener(this);
    }





    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        //creating a userinformation object


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_student:
                if (checked) {
                    //groupNumber.setVisibility(View.VISIBLE);
                    //check if user going to join student database
                    group = "students";
                    user_check = true;
                    break;
                }
            case R.id.radioButton_teacher:
                if (checked) {
                   // groupNumber.setVisibility(View.GONE);
                    //check if user going to join teacher database
                    group = "teachers";
                    user_check = false;
                    break;
                }
        }
    }


    private void saveUserInformation () {
        //Getting values from database
        String firstName = userName.getText().toString().trim();
        String lastName = userLastName.getText().toString().trim();


        //creating a userinformation object
        UserInfo_GetSet userInformation = new UserInfo_GetSet();

        userInformation.setFirstName(firstName);
        userInformation.setLastName(lastName);
        userInformation.setGroup(group);

        //getting the current logged in user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (TextUtils.isEmpty(firstName)) {
            //email is empty
            Toast.makeText(this, "Please enter your Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            //email is empty
            Toast.makeText(this, "Please enter your Last name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user_check) {
            databaseReference.child("userInformation").child(user.getUid()).setValue(userInformation);
            finish();
            //displaying a success toast
            Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }
        else if (!user_check) {
            databaseReference.child("userInformation").child(user.getUid()).setValue(userInformation);
            finish();
            //displaying a success toast
            Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }
    }



    @Override
    public void onClick(View view) {
        if (view == addUser)
                saveUserInformation();
    }


}
