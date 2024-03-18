package com.wit.S17.challange.dto;

import com.wit.S17.challange.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseResponse {
    // network 'te taşıyacağım class, benim dönüş değerim olacak, security için oluşturdum bu paketi.
    private Course course;
    private double Gpa;

}
