package com.mcode.alumninetwork3i.entity;

import com.mcode.alumninetwork3i.enums.UserGender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_alumni")
@NoArgsConstructor
public class UserEntity extends BaseEntity{

    private String firstName;

    private String lastName;

    // TODO  Change to Birthday
    private Integer age;

    private String email;

    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserGender gender;
}
