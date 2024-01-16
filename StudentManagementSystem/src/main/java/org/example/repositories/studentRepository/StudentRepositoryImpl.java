package org.example.repositories.studentRepository;

import org.example.models.Student;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl implements StudentRepository {

    final private EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) entityManager.remove(student);
    }

    @Override
    public Student update(Student student) {
        if (!entityManager.contains(student)) {
            return entityManager.merge(student);
        }
        return student;
    }
}
