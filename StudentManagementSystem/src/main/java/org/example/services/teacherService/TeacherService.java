package org.example.services.teacherService;

import org.example.models.Teacher;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    void deleteTeacherById(int id);

    Teacher updateTeacher(Teacher teacher);
}
