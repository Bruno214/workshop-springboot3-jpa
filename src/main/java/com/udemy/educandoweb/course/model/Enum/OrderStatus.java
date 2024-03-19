package com.udemy.educandoweb.course.model.Enum;

public enum OrderStatus {
  WAITING_PAYMENT(1),
  PAID(2),
  SHIPPED(3),

  DELIVERED(4),
  CANCELED(5);
  private Integer number;

  OrderStatus(Integer number) {
    this.number = number;
  }

  public Integer getNumber() {
    return number;
  }

  public static OrderStatus getTypeOrder(Integer numberOrder) {
    for (OrderStatus or : OrderStatus.values()) {
      if (or.getNumber().equals(numberOrder)) {
        return or;
      }
    }
    throw new IllegalArgumentException("Inválid order status code");
  }
}
