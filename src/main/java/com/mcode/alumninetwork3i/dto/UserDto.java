package com.mcode.alumninetwork3i.dto;

import com.mcode.alumninetwork3i.enums.UserGender;
import lombok.Data;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    // TODO  Change to Birthday
    private Integer age;

    private String email;

    private Integer phoneNumber;

    private UserGender gender;
}
