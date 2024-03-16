package com.wit.S17.challange.entity;

import org.springframework.stereotype.Component;

@Component
public class MediumCourseGPA implements CourseGPA{
    @Override
    public int GPA() {
        return 5;
    }
}
