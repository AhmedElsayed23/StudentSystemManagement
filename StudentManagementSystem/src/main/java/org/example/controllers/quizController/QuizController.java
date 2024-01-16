package org.example.controllers.quizController;

import org.example.models.Quiz;
import org.springframework.http.ResponseEntity;

public interface QuizController {

    ResponseEntity<Quiz> getQuizById(int id);

    ResponseEntity<Quiz> createQuiz(Quiz quiz);

    ResponseEntity<Void> deleteQuizById(int id);

    ResponseEntity<Quiz> updateQuiz(Quiz quiz);
}
