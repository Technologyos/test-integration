package com.technologyos.unittest.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Test math operations in Calculator class")
class CalculatorTest {
   private Calculator calculator;
   private Academy academy;

   @BeforeAll
   static void setupBeforeEachClass(){
      System.out.println("@BeforeAll executes only once before all test methods execution in the class");
   }

   @AfterAll
   static void cleanup(){
      System.out.println("@AfterAll executes only once after all test methods execution in the class");
   }

   @BeforeEach
   void beforeEachTestMethod(){
      academy = new Academy();
      calculator = new Calculator();
      System.out.println("@BeforeEach executes before the execution of each test method");
   }

   @AfterEach
   void afterEachTestMethod(){
      System.out.println("Executing @AfterEach method.");
   }

   @Test
   @Order(1)
   void testEqualsAndNotEquals() {
      assertEquals(6, calculator.add(2, 4), "2+4 must be 6");
      assertNotEquals(6, calculator.add(1, 9), "1+9 must not be 6");
   }

   @Test
   @Order(0)
   void testNullAndNotNull() {
      String str1 = null;
      String str2 = "myString";

      assertNull(calculator.checkNull(str1), "Object should be null");
      assertNotNull(calculator.checkNull(str2), "Object should not be null");
   }

   //test<System under test>_<Condition or state change>_<Expected result>
   @DisplayName("Test 4/2 = 2")
   @Test
   void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo(){
      //Arrange //given
      int dividend = 4;
      int divisor = 2;
      int expectedResult = 2;

      //Act //When
      int actualResult = calculator.integerDivision(dividend, divisor);

      //Assert //Then
      assertEquals(expectedResult, actualResult,"4/2 did not produce 2");
   }

   @DisplayName("Division by zero")
   @Test
   void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(){
      //Arrange //given
      int dividend = 4;
      int divisor = 0;
      String expectedExceptionMessage = "/ by zero";

      //Act and Assert
      ArithmeticException actualException = assertThrows(ArithmeticException.class, ()-> {
         calculator.integerDivision(dividend, divisor);
         }, "Division by zero should have thrown an arithmetic exception");

      //assert
      assertEquals(expectedExceptionMessage, actualException.getMessage(),
         "Unexpected exception message");
   }

   @DisplayName("Test integer subtraction [minuend, subtrahend, subtrahend]")
   @ParameterizedTest
   @MethodSource("integerSubtractionInputParameters")
   void integerSubtraction(int minuend, int subtrahend, int expectedResult){
      int actualResult = calculator.integerSubtraction(minuend, subtrahend);
      assertEquals(expectedResult, actualResult,
         () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
   }

   @Disabled("TODO: Still need to work on it")
   @Test
   void testDisabledLabel(){
      fail("no implemented yet");
   }

   private static Stream<Arguments> integerSubtractionInputParameters(){
      return Stream.of(
         Arguments.of(33, 1, 32),
         Arguments.of(54, 1, 53),
         Arguments.of(24, 1, 23)
      );
   }

   @DisplayName("Same and Not Same")
   @Test
   void testSameAndNotSame() {
      String str = "academy2";

      assertSame(academy.getAcademy(), academy.getAcademyDuplicate(), "Objects should refer to same object");
      assertNotSame(str, academy.getAcademy(), "Objects should not refer to same object");
   }

   @DisplayName("True and False")
   @Test
   void testTrueFalse() {
      int gradeOne = 10;
      int gradeTwo = 5;

      assertTrue(calculator.isGreater(gradeOne, gradeTwo), "This should return true");
      assertFalse(calculator.isGreater(gradeTwo, gradeOne), "This should return false");
   }

   @DisplayName("Array Equals")
   @Test
   void testArrayEquals() {
      String[] stringArray = {"A", "B", "C"};

      assertArrayEquals(stringArray, academy.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
   }

   @DisplayName("Iterable equals")
   @Test
   void testIterableEquals() {
      List<String> theList = List.of("aca", "de", "my");

      assertIterableEquals(theList, academy.getAcademyInList(), "Expected list should be same as actual list");
   }

   @DisplayName("Lines match")
   @Test
   void testLinesMatch() {
      List<String> theList = List.of("aca", "de", "my");

      assertLinesMatch(theList, academy.getAcademyInList(), "Lines should match");
   }

   @DisplayName("Throws and Does Not Throw")
   @Test
   void testThrowsAndDoesNotThrow() {
      assertThrows(Exception.class, () -> { calculator.throwException(-1); }, "Should throw exception");

      assertDoesNotThrow(() -> { calculator.throwException(5); }, "Should not throw exception");
   }

   @DisplayName("Timeout")
   @Test
   void testTimeout() {
      assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { calculator.checkTimeout(); },
         "Method should execute in 3 seconds");
   }
}
