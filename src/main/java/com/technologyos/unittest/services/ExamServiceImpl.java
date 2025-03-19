package com.technologyos.unittest.services;

import com.technologyos.unittest.models.Exam;
import com.technologyos.unittest.repositories.ExamRepository;
import com.technologyos.unittest.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

public class ExamServiceImpl implements ExamService{

    private ExamRepository examRepository;
    private QuestionRepository questionRepository;

    public ExamServiceImpl(ExamRepository examRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Exam> findExamByName(String name) {
        return examRepository.findAll()
                .stream()
                .filter(ex -> ex.getName().contains(name))
                .findFirst();
    }

    @Override
    public Optional<Exam> finExamByNameWithAllTheQuestions(String name) {
        Optional<Exam> currentExam = findExamByName(name);
        if(currentExam.isPresent()){
            List<String> questions = questionRepository.findQuestionsById(currentExam.get().getId());
            currentExam.get().setQuestions(questions);
            return currentExam;
        }
        return Optional.empty();
    }

    @Override
    public Exam save(Exam exam) {
        if(exam.getQuestions().isEmpty()){
            questionRepository.saveQuestions(exam.getQuestions());
        }
        return examRepository.save(exam);
    }

}
