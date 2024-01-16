package org.example.repositories.quizRepository;

import org.example.models.Quiz;

import javax.persistence.EntityManager;

public class QuizRepositoryImpl implements QuizRepository {

    final private EntityManager entityManager;

    public QuizRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Quiz save(Quiz quiz) {
        entityManager.persist(quiz);
        return quiz;
    }

    @Override
    public Quiz findById(int id) {
        return entityManager.find(Quiz.class, id);
    }

    @Override
    public void deleteById(int id) {
        Quiz quiz = entityManager.find(Quiz.class, id);
        if (quiz != null) {
            entityManager.remove(quiz);
        }
    }

    @Override
    public Quiz update(Quiz quiz) {
        if (!entityManager.contains(quiz)) {
            return entityManager.merge(quiz);
        }
        return quiz;
    }

}
