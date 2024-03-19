package com.udemy.educandoweb.course.repository.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.udemy.educandoweb.course.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
