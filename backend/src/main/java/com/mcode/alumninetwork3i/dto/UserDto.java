package com.mcode.alumninetwork3i.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String email;

    private String password;

    private Integer phoneNumber;

    private String profilePictureUrl;

    private String location;

    private String bio;

    private List<String> skills;

    private List<String> interest;
}
