package org.example.controllers.courseController;

import org.example.models.Course;
import org.springframework.http.ResponseEntity;

public interface CourseController {

    ResponseEntity<Course> getCourseById(int id);

    ResponseEntity<Course> createCourse(Course course);

    ResponseEntity<Void> deleteCourseById(int id);

    ResponseEntity<Course> updateCourse(Course course);
}
