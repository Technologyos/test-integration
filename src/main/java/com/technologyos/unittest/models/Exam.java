package com.technologyos.unittest.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Exam {
   @NotNull
   private Long id;
   @NotNull
   private String name;
   private List<String> questions = new ArrayList<>();
}
