package org.example.services.courseService;

import org.example.models.Course;

public interface CourseService {

    Course saveCourse(Course course);

    Course getCourseById(int id);

    void deleteCourseById(int id);

    Course updateCourse(Course course);
}
