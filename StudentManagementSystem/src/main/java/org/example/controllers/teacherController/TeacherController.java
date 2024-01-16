package org.example.controllers.teacherController;

import org.example.models.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherController {

    ResponseEntity<Teacher> getTeacherById(int id);

    ResponseEntity<Teacher> createTeacher(Teacher teacher);

    ResponseEntity<Void> deleteTeacherById(int id);

    ResponseEntity<Teacher> updateTeacher(Teacher teacher);
}
