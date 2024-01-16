package org.example.controllers.studentController;

import org.example.models.Student;
import org.springframework.http.ResponseEntity;


public interface StudentController {

    ResponseEntity<Student> getStudentById(int id);

    ResponseEntity<Student> createStudent(Student student);

    ResponseEntity<Void> deleteStudentById(int id);

    ResponseEntity<Student> updateStudent(Student student);

}
