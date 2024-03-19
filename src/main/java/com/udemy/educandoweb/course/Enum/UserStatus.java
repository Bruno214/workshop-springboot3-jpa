package com.udemy.educandoweb.course.Enum;

public enum UserStatus {
  OPEN("0"),
  CLOSED("1");

  private String number;

  UserStatus(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }
}
