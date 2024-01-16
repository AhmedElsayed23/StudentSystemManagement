package org.example.services.studentService;

import org.example.models.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    Student getStudentById(int id);

    void deleteStudentById(int id);

    Student updateStudent(Student student);
}
