package com.technologyos.unittest.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InsufficientMoneyException extends RuntimeException {
   public InsufficientMoneyException(String message){
      super(message);
   }
}
