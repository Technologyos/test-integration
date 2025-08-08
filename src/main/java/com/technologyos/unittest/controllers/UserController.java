package com.technologyos.unittest.controllers;

import com.technologyos.unittest.dtos.UserDto;
import com.technologyos.unittest.dtos.request.UserDetailRequest;
import com.technologyos.unittest.dtos.response.UserResponse;
import com.technologyos.unittest.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
   private final UserService usersService;

   @PostMapping
   public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserDetailRequest userDetails) {
      ModelMapper modelMapper = new ModelMapper();
      UserDto userDto = new ModelMapper().map(userDetails, UserDto.class);

      UserDto createdUser = usersService.createUser(userDto);
      UserResponse userResponse = modelMapper.map(createdUser, UserResponse.class);

      return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
   }

   @GetMapping
   public List<UserResponse> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "limit", defaultValue = "2") int limit) {
      List<UserDto> users = usersService.getUsers(page, limit);

      Type listType = new TypeToken<List<UserResponse>>() {}.getType();

      return new ModelMapper().map(users, listType);
   }
}
