package com.technologyos.unittest.utils;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

   public int add(int a, int b) {
      return a + b;
   }

   public int multiply(int a, int b) {
      return a * b;
   }

   public Object checkNull(Object obj) {
      return obj;
   }

   public Boolean isGreater(int n1, int n2) {
      return n1 > n2;
   }

   public String throwException(int a) throws Exception {
      if (a < 0) {
         throw new Exception("Value should be greater than or equal to 0");
      }
      return "Value is greater than or equal to 0";
   }

   public void checkTimeout() throws InterruptedException {
      System.out.println("I am going to sleep");
      Thread.sleep(2000);
      System.out.println("Sleeping over");
   }

   public int integerDivision(int dividend, int divisor){
      return dividend/divisor;
   }

   public int integerSubtraction(int minuend, int subtrahend) {
      return minuend - subtrahend;
   }
}
