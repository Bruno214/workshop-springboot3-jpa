package com.udemy.educandoweb.course.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class User implements Serializable {

  private static final long serialVersionUID=1L;

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String password;
}
