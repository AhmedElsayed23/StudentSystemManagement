package org.example.repositories.courseRepository;

import org.example.models.Course;

public interface CourseRepository {

    Course save(Course course);

    Course findById(int id);

    void deleteById(int id);

    Course update(Course course);
}
