package com.technologyos.unittest.services.impl;

import com.technologyos.unittest.models.Exam;
import com.technologyos.unittest.repositories.ExamRepository;
import com.technologyos.unittest.repositories.QuestionRepository;
import com.technologyos.unittest.services.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {
   private final ExamRepository examRepository;
   private final QuestionRepository questionRepository;

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
