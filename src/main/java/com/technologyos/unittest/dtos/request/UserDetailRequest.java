package com.technologyos.unittest.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailRequest {
   @Size(min = 2, message = "First name must not be less than 2 characters")
   private String firstName;

   @Size(min = 2, message = "Last name must not be less than 2 characters")
   private String lastName;

   @Email
   private String email;

   @Size(min = 8, max = 16, message = "Password must be equal to or greater than 8 characters and less than 16 characters")
   private String password;

   @Size(min = 8, max = 16, message = "Repeat Password must be equal to or greater than 8 characters and less than 16 characters")
   private String repeatPassword;
}
