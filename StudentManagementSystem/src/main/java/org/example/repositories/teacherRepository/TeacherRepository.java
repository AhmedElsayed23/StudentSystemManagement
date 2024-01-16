package org.example.repositories.teacherRepository;

import org.example.models.Teacher;

public interface TeacherRepository {

    Teacher save(Teacher teacher);

    Teacher findById(int id);

    void deleteById(int id);

    Teacher update(Teacher teacher);
}
