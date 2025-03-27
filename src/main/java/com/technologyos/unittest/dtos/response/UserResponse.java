package com.technologyos.unittest.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
   private String userId;
   private String firstName;
   private String lastName;
   private String email;
}

