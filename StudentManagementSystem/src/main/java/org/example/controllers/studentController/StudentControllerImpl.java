package org.example.controllers.studentController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.models.Student;
import org.example.services.studentService.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class StudentControllerImpl implements StudentController, HttpRequestHandler {

    private final StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String requestURI = request.getRequestURI(); // /students/list
        String[] pathParts = requestURI.split("/"); // ["","", "students", "list"]
        String operation = pathParts[3]; // list

        switch (operation) {
            case "add":
                Student student = objectMapper.readValue(request.getReader(), Student.class);
                ResponseEntity<Student> studentResponseEntity = createStudent(student);
                writeResponse(response, studentResponseEntity);
                break;
            case "update":
                Student studentToUpdate = objectMapper.readValue(request.getReader(), Student.class);
                ResponseEntity<Student> studentResponseEntity1 = updateStudent(studentToUpdate);
                writeResponse(response, studentResponseEntity1);
                break;
            case "delete":
                ResponseEntity<Void> voidResponseEntity = deleteStudentById(Integer.parseInt(pathParts[4]));
                writeResponse(response, voidResponseEntity);
                break;
            case "get":
                ResponseEntity<Student> studentResponseEntity2 = getStudentById(Integer.parseInt(pathParts[4]));
                writeResponse(response, studentResponseEntity2);
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
    public ResponseEntity<Student> getStudentById(int id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        Student student1 = studentService.saveStudent(student);
        return ResponseEntity.ok(student1);
    }

    @Override
    public ResponseEntity<Void> deleteStudentById(int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Student> updateStudent(Student student) {
        Student student1 = studentService.updateStudent(student);
        return ResponseEntity.ok(student1);
    }
}
