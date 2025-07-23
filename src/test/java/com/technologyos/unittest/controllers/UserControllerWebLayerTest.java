package com.technologyos.unittest.controllers;

import com.technologyos.unittest.dtos.UserDto;
import com.technologyos.unittest.dtos.request.UserDetailRequest;
import com.technologyos.unittest.dtos.response.UserResponse;
import com.technologyos.unittest.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(
   controllers = UserController.class,
   excludeAutoConfiguration = {SecurityAutoConfiguration.class}
)
@Import(UserControllerWebLayerTest.TestConfig.class)
public class UserControllerWebLayerTest {
   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private UserService usersService;

   private UserDetailRequest userDetailRequest;

   @BeforeEach
   void setup() {
      userDetailRequest = new UserDetailRequest();
      userDetailRequest.setFirstName("Armando");
      userDetailRequest.setLastName("Salazar");
      userDetailRequest.setEmail("asalazarj@gmail.com");
      userDetailRequest.setPassword("admin123456");
   }

   @Test
   @DisplayName("User can be created")
   void testCreateUser_whenValidUserDetailsProvided_returnsCreatedUserDetails() throws Exception {
      // Arrange
      UserDto userDto = new ModelMapper().map(userDetailRequest, UserDto.class);
      userDto.setUserId(UUID.randomUUID().toString());
      Mockito
         .when(usersService.createUser(any(UserDto.class)))
         .thenReturn(userDto);

      RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
         .contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON)
         .content(new ObjectMapper().writeValueAsString(userDetailRequest));

      // Act
      MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
      String responseBodyAsString = mvcResult.getResponse().getContentAsString();
      UserResponse createdUser = new ObjectMapper()
         .readValue(responseBodyAsString, UserResponse.class);

      // Assert
      assertEquals(userDetailRequest.getFirstName(),
         createdUser.getFirstName(), "The returned user first name is most likely incorrect");

      assertEquals(userDetailRequest.getLastName(),
         createdUser.getLastName(), "The returned user last name is incorrect");

      assertEquals(userDetailRequest.getEmail(),
         createdUser.getEmail(), "The returned user email is incorrect");

      assertFalse(createdUser.getUserId().isEmpty(), "userId should not be empty");
   }

   @Test
   @DisplayName("First name is not empty")
   void testCreateUser_whenFirstNameIsNotProvided_returns400StatusCode() throws Exception {
      // Arrange
      userDetailRequest.setFirstName("");

      RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
         .contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON)
         .content(new ObjectMapper().writeValueAsString(userDetailRequest));

      // Act
      MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

      // Assert
      assertEquals(HttpStatus.BAD_REQUEST.value(),
         mvcResult.getResponse().getStatus(),
         "Incorrect HTTP Status Code returned");
   }

   @Test
   @DisplayName("First name cannot be shorter than 2 characters")
   void testCreateUser_whenFirstNameIsOnlyOneCharacter_returns400StatusCode() throws Exception {
      // Arrange
      userDetailRequest.setFirstName("a");

      RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
         .content(new ObjectMapper().writeValueAsString(userDetailRequest))
         .contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON);

      // Act
      MvcResult result = mockMvc.perform(requestBuilder).andReturn();

      // Assert
      assertEquals(HttpStatus.BAD_REQUEST.value(),
         result.getResponse().getStatus(), "HTTP Status code is not set to 400");
   }

   @TestConfiguration
   static class TestConfig {

      @Bean
      public UserService usersService() {
         return Mockito.mock(UserService.class);
      }
   }
}
