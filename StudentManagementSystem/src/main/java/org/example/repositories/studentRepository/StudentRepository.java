package org.example.repositories.studentRepository;

import org.example.models.Student;

public interface StudentRepository {

    Student save(Student student);

    Student findById(int id);

    void deleteById(int id);

    Student update(Student student);
}
