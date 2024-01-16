package org.example.services.teacherService;

import org.example.models.Teacher;
import org.example.repositories.teacherRepository.TeacherRepository;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.update(teacher);
    }
}
