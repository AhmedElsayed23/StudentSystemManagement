package org.example.controllers.quizController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.models.Quiz;
import org.example.services.quizService.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuizControllerImpl implements QuizController, HttpRequestHandler {

    final private QuizService quizService;

    public QuizControllerImpl(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String requestURI = request.getRequestURI(); // /quizzes/list
        String[] pathParts = requestURI.split("/"); // ["","", "quizzes", "list"]
        String operation = pathParts[3]; // list

        switch (operation) {
            case "add":
                Quiz quiz = objectMapper.readValue(request.getReader(), Quiz.class);
                ResponseEntity<Quiz> quiz1 = createQuiz(quiz);
                writeResponse(response, quiz1);
                break;
            case "update":
                Quiz quizToUpdate = objectMapper.readValue(request.getReader(), Quiz.class);
                ResponseEntity<Quiz> quiz2 = updateQuiz(quizToUpdate);
                writeResponse(response, quiz2);
                break;
            case "delete":
                deleteQuizById(Integer.parseInt(pathParts[4]));
                break;
            case "get":
                ResponseEntity<Quiz> quiz3 = getQuizById(Integer.parseInt(pathParts[4]));
                writeResponse(response, quiz3);
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
    public ResponseEntity<Quiz> getQuizById(int id) {
        Quiz quiz = quizService.getQuizById(id);
        return ResponseEntity.ok(quiz);
    }

    @Override
    public ResponseEntity<Quiz> createQuiz(Quiz quiz) {
        Quiz savedQuiz = quizService.saveQuiz(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    @Override
    public ResponseEntity<Void> deleteQuizById(int id) {
        quizService.deleteQuizById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Quiz> updateQuiz(Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(quiz);
        return ResponseEntity.ok(updatedQuiz);
    }
}
