package com.technologyos.unittest.repositories;

import com.technologyos.unittest.models.Exam;
import com.technologyos.unittest.utils.ConstantsV;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository{
   @Override
   public Exam save(Exam exam) {
      return ConstantsV.EXAM;
   }

   @Override
   public List<Exam> findAll() {
      return ConstantsV.LIST_OF_EXAMS;
   }
}
