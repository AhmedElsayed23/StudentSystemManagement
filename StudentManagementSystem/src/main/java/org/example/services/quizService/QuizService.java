package org.example.services.quizService;

import org.example.models.Quiz;

import java.util.List;

public interface QuizService {

    Quiz saveQuiz(Quiz quiz);

    Quiz getQuizById(int id);

    void deleteQuizById(int id);

    Quiz updateQuiz(Quiz quiz);
}
