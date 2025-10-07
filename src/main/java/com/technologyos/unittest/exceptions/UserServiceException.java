package com.technologyos.unittest.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserServiceException extends RuntimeException {
   public UserServiceException(String message) {
      super(message);
   }
}
