package com.technologyos.unittest.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
   @NotNull
   private Long id;
   @NotNull
   private String name;
   private List<String> questions = new ArrayList<>();

   public Exam(Long id, String name) {
      this.id = id;
      this.name = name;
   }
}
