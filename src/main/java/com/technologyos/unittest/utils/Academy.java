package com.technologyos.unittest.utils;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Academy {
   private final String academy = "academy";
   private final String academyDuplicate = academy;
   private final String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
   private final List<String> academyInList = List.of("aca", "de", "my");
}
