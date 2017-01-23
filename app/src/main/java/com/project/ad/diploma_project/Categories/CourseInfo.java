package com.project.ad.diploma_project.Categories;

/**
 * Created by menri on 21.12.2016.
 */

public class CourseInfo {
    public String courseTitle;
    public String courseDescription;
    public String imageSrc;


    public CourseInfo (String courseTitle, String courseDescription, String imageSrc){
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.imageSrc = imageSrc;
    }

    public CourseInfo(){

    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
