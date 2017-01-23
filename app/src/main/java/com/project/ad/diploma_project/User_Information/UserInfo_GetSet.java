package com.project.ad.diploma_project.User_Information;

import android.app.Application;

/**
 * Created by menri on 29.11.2016.
 */

public class UserInfo_GetSet {


        public String firstName;
        public String lastName;
        public String group;

        public UserInfo_GetSet(){

        }

        //Getters and setters
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String name) {
            this.firstName = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGroup(){
            return group;
        }

        public void setGroup (String group){
            this.group = group;
        }


}
