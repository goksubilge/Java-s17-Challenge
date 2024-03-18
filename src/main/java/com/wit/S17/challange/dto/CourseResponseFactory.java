package com.wit.S17.challange.dto;

import com.wit.S17.challange.entity.*;

// Single responsibility

public class CourseResponseFactory {
    public static CourseResponse createCourseResponse(Course course, CourseGPA lowGPA, CourseGPA mediumGPA, CourseGPA highGPA) {
        if (course.getCredit() <= 2) {
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit() * ((LowCourseGPA) lowGPA).GPA());
        } else if (course.getCredit() == 3){
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit() * ((MediumCourseGPA) mediumGPA).GPA());
        } else if (course.getCredit() == 4){
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit() * ((HighCourseGPA) highGPA).GPA());
        }
        return null;
    }
}
