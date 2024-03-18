package com.udemy.educandoweb.course.service;

import com.udemy.educandoweb.course.model.User;
import com.udemy.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll(){
    return userRepository.findAll();
  }

  public User findUserById(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    }
    throw new RuntimeException("User not found");

  }
}
