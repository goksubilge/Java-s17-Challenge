package com.wit.S17.challange.controller;

import com.wit.S17.challange.dto.CourseResponse;
import com.wit.S17.challange.dto.CourseResponseFactory;
import com.wit.S17.challange.entity.Course;
import com.wit.S17.challange.entity.CourseGPA;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/")
    public List<Course> getCourses(){return courses;}

    @GetMapping("/{name}")
    public Course findCourse(@PathVariable String name) {
        // courses.stream().filter(course -> course.getName().equals(name)).findFirst();
        // 1.) bu logic i yazdık.
        // isim UNIC olacak  yüzden findFirst()
        //  2.) findFirst hangi tip dönüyor diye baktık, uyarı verdi zaten. Optional type.
        //  3.) bi kırılma noktası oluyor Optional 'da ya break yapacaksın ya da if ile koşulunu yazacaksın.
        Optional<Course> optCourse = courses.stream().filter(course -> course.getName().equals(name)).findFirst();
        if(optCourse.isPresent()){
            return optCourse.get();
        } else {
            //TODO throw course not found exception
            return null;
        }
    }
    // NOT: dönüş değerlerim hiç bir zaman entity class isimlerime aynı olmamalı. bunun için bir dto package tanımlamalıyım. yani "public Course .." burada Course u gidip dto --> CourseResponse class 'ında tanımlayacağım.
    // Dolayısıyla artık 'public Course ...' yerine 'public CourseResponse ...' dönüş değerini salıyorum. dto üzerinden.

    @PostMapping("/")
    public CourseResponse save(@RequestBody Course course){
       //TODO Validation
       courses.add(course);
       return CourseResponseFactory.createCourseResponse(course,lowGPA,mediumGPA,highGPA);
    }


}
