package com.technologyos.unittest.controllers;

import com.technologyos.unittest.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
   private final UsersService usersService;

}
