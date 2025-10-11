package com.technologyos.unittest.repositories.impl;

import com.technologyos.unittest.repositories.QuestionRepository;
import com.technologyos.unittest.utils.ConstantsV;

import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

   @Override
   public List<String> findQuestionsById(Long id) {
      return ConstantsV.QUESTIONS;
   }

   @Override
   public void saveQuestions(List<String> questions) {
      System.out.println("Doing something");
   }
}
