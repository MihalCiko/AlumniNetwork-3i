package com.mcode.alumninetwork3i.dto.UserDto;

import com.mcode.alumninetwork3i.enums.UserGender;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String email;

    private Integer phoneNumber;

    private UserGender gender;

    private List<String> skills;

    private List<String> interest;
}
