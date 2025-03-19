package com.technologyos.unittest.services;

import com.technologyos.unittest.models.Exam;

import java.util.Optional;

public interface ExamService {
    Optional<Exam> findExamByName(String name);
    Optional<Exam> finExamByNameWithAllTheQuestions(String name);
    Exam save(Exam exam);
}
