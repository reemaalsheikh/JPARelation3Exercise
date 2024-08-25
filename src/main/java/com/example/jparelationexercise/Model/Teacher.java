package com.example.jparelationexercise.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
//Teacher Class:
//( Add all required validation )
public class Teacher {

//id
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

//name
@NotEmpty(message = "Name should not be empty!")
@Column(columnDefinition = "varchar(30) not null")
private String name;

//age
@NotNull(message = "Age should not be null!")
@Column(columnDefinition = "int not null")
private Integer age;

//email
@Email
@NotEmpty(message = "Email should not be Empty!")
@Column(columnDefinition = "varchar(50) not null unique")
private String email;

//salary
@NotNull(message = "Salary should not be null!")
@Column(columnDefinition = "DOUBLE not null")
private double salary;


@OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
@PrimaryKeyJoinColumn
private Address address;


@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
private Set<Course> courses;



}
