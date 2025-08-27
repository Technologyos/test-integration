package com.technologyos.unittest.controllers;

import com.technologyos.unittest.models.Account;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {

   @GetMapping("/{id}")
   public Account detail(@PathVariable(name = "id") long id){
      return null;
   }
}
