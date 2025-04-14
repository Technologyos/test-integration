package com.technologyos.unittest.controllers;

import com.technologyos.unittest.dtos.UserDto;
import com.technologyos.unittest.dtos.request.UserDetailRequest;
import com.technologyos.unittest.dtos.response.UserResponse;
import com.technologyos.unittest.services.UsersService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
   private final UsersService usersService;

   @PostMapping
   public UserResponse createUser(@RequestBody @Valid UserDetailRequest userDetails) throws Exception {
      ModelMapper modelMapper = new ModelMapper();
      UserDto userDto = new ModelMapper().map(userDetails, UserDto.class);

      UserDto createdUser = usersService.createUser(userDto);

      return modelMapper.map(createdUser, UserResponse.class);
   }

   @GetMapping
   public List<UserResponse> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "limit", defaultValue = "2") int limit) {
      List<UserDto> users = usersService.getUsers(page, limit);

      Type listType = new TypeToken<List<UserResponse>>() {}.getType();

      return new ModelMapper().map(users, listType);
   }
}
