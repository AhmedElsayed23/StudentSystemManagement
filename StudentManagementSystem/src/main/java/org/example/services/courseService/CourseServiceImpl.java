package org.example.services.courseService;

import org.example.models.Course;
import org.example.repositories.courseRepository.CourseRepository;


public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.update(course);
    }
}
