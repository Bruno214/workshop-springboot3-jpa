package com.udemy.educandoweb.course.controller.usercontroller;

import com.udemy.educandoweb.course.model.user.User;
import com.udemy.educandoweb.course.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  public UserService userService;
  @Autowired
  public UserController(UserService userService){
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> listUsers = userService.findAll();
    return ResponseEntity.ok().body(listUsers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
    User user = userService.findUserById(id);
    return ResponseEntity.ok().body(user);
  }
}
