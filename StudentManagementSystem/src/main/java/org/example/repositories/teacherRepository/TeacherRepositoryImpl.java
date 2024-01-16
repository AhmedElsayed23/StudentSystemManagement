package org.example.repositories.teacherRepository;

import org.example.models.Teacher;

import javax.persistence.EntityManager;

public class TeacherRepositoryImpl implements TeacherRepository{

    final private EntityManager entityManager;

    public TeacherRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher save(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher findById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void deleteById(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
    }

    @Override
    public Teacher update(Teacher teacher) {
        if (!entityManager.contains(teacher)) {
            return entityManager.merge(teacher);
        }
        return teacher;
    }

}
