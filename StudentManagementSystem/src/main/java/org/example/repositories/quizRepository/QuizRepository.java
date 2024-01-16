package org.example.repositories.quizRepository;

import org.example.models.Quiz;


public interface QuizRepository {

    Quiz save(Quiz quiz);

    Quiz findById(int id);

    void deleteById(int id);

    Quiz update(Quiz quiz);
}
