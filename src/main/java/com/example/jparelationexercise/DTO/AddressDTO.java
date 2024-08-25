package com.example.jparelationexercise.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher id should not be null!")
    private Integer teacher_id;


    @NotEmpty(message = "Area should not be empty!")
    private String area;


    @NotEmpty(message = "Street should not be empty!")
    private String street;


    @NotNull(message = "Building Number should not be null!")
    private int buildingNumber;



}
