package com.technologyos.unittest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private String username;
   private String name;
   private int age;
   private String lastname;
   private String firstname;
}
