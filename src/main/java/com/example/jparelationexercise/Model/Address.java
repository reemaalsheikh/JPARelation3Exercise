package com.example.jparelationexercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//Address Class :
//(Add all required validation)

public class Address {

 @Id
private Integer id;

//area
@NotEmpty(message = "Area should not be empty!")
@Column(columnDefinition = "varchar(30) not null")
private String area;

// street
@NotEmpty(message = "Street should not be empty!")
@Column(columnDefinition = "varchar(30) not null")
private String street;

// buildingNumber
@NotNull(message = "Building Number should not be null!")
@Column(columnDefinition = "int not null")
private int buildingNumber;


@OneToOne
@MapsId
@JsonIgnore
private Teacher teacher;

}
