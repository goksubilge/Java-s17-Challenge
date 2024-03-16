package com.wit.S17.challange.controller;

import com.wit.S17.challange.entity.Course;
import com.wit.S17.challange.entity.CourseGPA;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // create CourseController 's instance
@RequestMapping("/courses")
public class CourseController {
    private List<Course> courses;
    private CourseGPA lowGPA;
    private CourseGPA mediumGPA;
    private CourseGPA highGPA;

   @PostConstruct
   public void init() {
       courses = new ArrayList<>();
   }

   @Autowired  // DEPENDENCY INJECTION  => must sign classes @Component for recognising and creating the instance
    public CourseController(@Qualifier("lowCourseGPA") CourseGPA lowGPA,
                            @Qualifier("mediumCourseGPA")CourseGPA mediumGPA,
                            @Qualifier("highCourseGPA")CourseGPA highGPA) {
        this.lowGPA = lowGPA;
        this.mediumGPA = mediumGPA;
        this.highGPA = highGPA;
    }
}
