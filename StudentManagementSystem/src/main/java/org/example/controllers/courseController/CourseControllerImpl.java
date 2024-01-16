package org.example.controllers.courseController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.models.Course;
import org.example.services.courseService.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CourseControllerImpl implements CourseController, HttpRequestHandler {

    private final CourseService courseService;

    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String requestURI = request.getRequestURI(); // /courses/list
        String[] pathParts = requestURI.split("/"); // ["","", "courses", "list"]
        String operation = pathParts[3]; // list

        switch (operation) {
            case "add":
                Course course = objectMapper.readValue(request.getReader(), Course.class);
                ResponseEntity<Course> course1 = createCourse(course);
                writeResponse(response, course1);
                break;
            case "update":
                Course courseToUpdate = objectMapper.readValue(request.getReader(), Course.class);
                ResponseEntity<Course> course2 = updateCourse(courseToUpdate);
                writeResponse(response, course2);
                break;
            case "delete":
                deleteCourseById(Integer.parseInt(pathParts[4]));
                break;
            case "get":
                ResponseEntity<Course> course3 = getCourseById(Integer.parseInt(pathParts[4]));
                writeResponse(response, course3);
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
    public ResponseEntity<Course> getCourseById(int id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @Override
    public ResponseEntity<Course> createCourse(Course course) {
        Course course1 = courseService.saveCourse(course);
        return ResponseEntity.ok(course1);
    }

    @Override
    public ResponseEntity<Void> deleteCourseById(int id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Course> updateCourse(Course course) {
        Course course1 = courseService.updateCourse(course);
        return ResponseEntity.ok(course1);
    }
}
