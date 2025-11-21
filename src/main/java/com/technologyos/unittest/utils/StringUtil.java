package com.technologyos.unittest.utils;

public class StringUtil {

   public static String repeat(String str, int times){
      if (times < 0) {
         throw new IllegalArgumentException("negative times not allowed");
      }

      return String.valueOf(str).repeat(times);
    }
}
