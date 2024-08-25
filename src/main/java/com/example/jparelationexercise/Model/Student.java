package com.example.jparelationexercise.Model;

import jakarta.persistence.*;
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty!")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "Age should not be null!")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "Major should not be empty!")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
