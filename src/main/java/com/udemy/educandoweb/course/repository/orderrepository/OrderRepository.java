package com.udemy.educandoweb.course.repository.orderrepository;

import com.udemy.educandoweb.course.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
