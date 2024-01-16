package org.example.services.quizService;

import org.example.models.Quiz;
import org.example.repositories.quizRepository.QuizRepository;

import java.util.List;

public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(int id) {
        return quizRepository.findById(id);
    }

    @Override
    public void deleteQuizById(int id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.update(quiz);
    }
}
