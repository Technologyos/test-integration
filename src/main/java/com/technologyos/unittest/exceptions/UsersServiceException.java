package com.technologyos.unittest.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsersServiceException extends RuntimeException {
   public UsersServiceException(String message) {
      super(message);
   }
}
