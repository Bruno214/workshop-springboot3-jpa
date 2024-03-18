package com.udemy.educandoweb.course.controller;

import com.udemy.educandoweb.course.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping
  public ResponseEntity<User> findAll() {
    var userNew = new User();
    userNew.setName("bruno");
    return ResponseEntity.ok().body(userNew);
  }
}
