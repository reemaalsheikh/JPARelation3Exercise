package com.example.jparelationexercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
//Course Class :
public class Course {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // name ( all should not be empty )
    @NotEmpty(message = "Name should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;


    //Many courses to one merchant
    @ManyToOne
    @JoinColumn(name= "teacher_id" , referencedColumnName = "id") //optional
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany
    @JsonIgnore
    private Set<Student> students ;

}
