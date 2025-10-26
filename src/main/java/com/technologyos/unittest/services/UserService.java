package com.technologyos.unittest.services;

import com.technologyos.unittest.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
   UserDto createUser(UserDto user);

   List<UserDto> getUsers(int page, int limit);

   UserDto getUser(String email);
}
