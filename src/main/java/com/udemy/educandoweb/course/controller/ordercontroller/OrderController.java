package com.udemy.educandoweb.course.controller.ordercontroller;


import com.udemy.educandoweb.course.model.order.Order;
import com.udemy.educandoweb.course.service.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public ResponseEntity<List<Order>> findAll() {
    List<Order> listOrder = this.orderService.findAll();
    return ResponseEntity.ok().body(listOrder);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
    Order order = this.orderService.findOrderById(id);
    return ResponseEntity.ok().body(order);
  }
}