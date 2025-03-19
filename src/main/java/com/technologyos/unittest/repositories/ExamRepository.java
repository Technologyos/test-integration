package com.technologyos.unittest.repositories;

import com.technologyos.unittest.models.Exam;

import java.util.List;

public interface ExamRepository {
    Exam save(Exam exam);
    List<Exam> findAll();
}
