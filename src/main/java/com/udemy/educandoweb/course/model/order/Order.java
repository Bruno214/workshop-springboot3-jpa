package com.udemy.educandoweb.course.model.order;

import com.udemy.educandoweb.course.model.Enum.OrderStatus;
import com.udemy.educandoweb.course.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
public class Order implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Instant moment;

  private Integer orderStatus;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
    this.id = id;
    this.moment = moment;
    this.orderStatus = orderStatus.getNumber();
    this.client = client;
  }
}
