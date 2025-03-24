package com.technologyos.unittest.exceptions;

public class InsufficientMoneyException extends RuntimeException {
   public InsufficientMoneyException(String message){
      super(message);
   }
}
