package com.technologyos.unittest.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {
   @Serial
   private static final long serialVersionUID = 1213493413859894403L;

   private String userId;
   private String firstName;
   private String lastName;
   private String email;
}

