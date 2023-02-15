package com.olakunle.entities;

import com.olakunle.entities.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private  String email;
    private Gender gender;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDate dateOfBirth;
    private List<Product> products;
}
