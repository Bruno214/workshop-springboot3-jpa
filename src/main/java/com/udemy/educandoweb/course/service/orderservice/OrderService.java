package com.udemy.educandoweb.course.service.orderservice;

import com.udemy.educandoweb.course.model.order.Order;
import com.udemy.educandoweb.course.repository.orderrepository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

  private OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> findAll(){
    return this.orderRepository.findAll();
  }

  public Order findOrderById(Long id) {
    Optional<Order> optionalOrder = this.orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      return optionalOrder.get();
    }
    throw new RuntimeException("Order não encontrado");

  }
}
