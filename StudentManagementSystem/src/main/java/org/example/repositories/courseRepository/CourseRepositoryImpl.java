package org.example.repositories.courseRepository;

import org.example.models.Course;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl implements CourseRepository {

    final private EntityManager entityManager;

    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteById(int id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    @Override
    public Course update(Course course) {
        if (!entityManager.contains(course)) {
            return entityManager.merge(course);
        }
        return course;
    }

}
