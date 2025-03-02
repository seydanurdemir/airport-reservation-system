package com.sakinr.patika.airportreservatinsystem.model;

import lombok.Data;

@Data
public class PassengerDto {

    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private String phone;
    private String email;
}
