package com.udemy.educandoweb.course.config;

import com.udemy.educandoweb.course.model.Enum.OrderStatus;
import com.udemy.educandoweb.course.model.order.Order;
import com.udemy.educandoweb.course.model.user.User;
import com.udemy.educandoweb.course.repository.orderrepository.OrderRepository;
import com.udemy.educandoweb.course.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  private UserRepository userRepository;
  private OrderRepository orderRepository;
  private static List<User> listUsers;

  @Autowired
  public TestConfig(UserRepository userRepository, OrderRepository orderRepository){
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
    listUsers = new ArrayList<>();
  }

  @Override
  public void run(String... args) throws Exception {

    listUsers = this.userRepository.saveAll(createdUsers());
    this.orderRepository.saveAll(createdOrders());
  }

  public static List<User> createdUsers() {
    User userOne = new User(null, "Maria Brown", "maria@gmail.com", "988888888","123456");
    User userTwo = new User(null, "Alex Green", "alex@gmail.com", "977777777","1234567");
    return Arrays.asList(userOne, userTwo);
  }

  public static List<Order> createdOrders() {
    User clientOne = listUsers.get(0);
    User clientTwo = listUsers.get(1);
    Order orderOne = new Order(null, Instant.parse("2024-02-29T12:00:00Z"), OrderStatus.PAID, clientOne);
    Order orderTwo = new Order(null, Instant.parse("2024-01-29T12:10:18Z"), OrderStatus.WAITING_PAYMENT, clientTwo);
    Order orderThree = new Order(null, Instant.parse("2023-12-20T14:05:02Z"), OrderStatus.WAITING_PAYMENT, clientOne);

    return Arrays.asList(orderOne, orderTwo, orderThree);
  }
}
