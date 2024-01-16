package org.example.controllers.teacherController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.models.Teacher;
import org.example.services.teacherService.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TeacherControllerImpl implements TeacherController, HttpRequestHandler {

    final private TeacherService teacherService;

    public TeacherControllerImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String requestURI = request.getRequestURI(); // /teachers/list
        String[] pathParts = requestURI.split("/"); // ["","", "teachers", "list"]
        String operation = pathParts[3]; // list

        switch (operation) {
            case "add":
                Teacher teacher = objectMapper.readValue(request.getReader(), Teacher.class);
                ResponseEntity<Teacher> teacher1 = createTeacher(teacher);
                writeResponse(response, teacher1);
                break;
            case "update":
                Teacher teacherToUpdate = objectMapper.readValue(request.getReader(), Teacher.class);
                ResponseEntity<Teacher> teacher2 = updateTeacher(teacherToUpdate);
                writeResponse(response, teacher2);
                break;
            case "delete":
                deleteTeacherById(Integer.parseInt(pathParts[4]));
                break;
            case "get":
                ResponseEntity<Teacher> teacher3 = getTeacherById(Integer.parseInt(pathParts[4]));
                writeResponse(response, teacher3);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    private void writeResponse(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new ObjectMapper().writeValueAsString(object));
        out.flush();
    }

    @Override
    public ResponseEntity<Teacher> getTeacherById(int id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @Override
    public ResponseEntity<Teacher> createTeacher(Teacher teacher) {
        Teacher teacher1 = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(teacher1);
    }

    @Override
    public ResponseEntity<Void> deleteTeacherById(int id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Teacher> updateTeacher(Teacher teacher) {
        Teacher teacher1 = teacherService.updateTeacher(teacher);
        return ResponseEntity.ok(teacher1);
    }
}
