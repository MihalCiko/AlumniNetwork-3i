package com.mcode.alumninetwork3i.entity;

import com.mcode.alumninetwork3i.enums.UserGender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "alumni")
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // TODO  Change to Birthday
    private Integer age;

    private String email;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private String education;

    @OneToMany(mappedBy = "user")
    private List<EmploymentHistoryEntity> employmentHistoryEntities;


    @Convert(converter = ListConverter.class)
    private List<String> skills;

    @Convert(converter = ListConverter.class)
    private List<String> interest;

    public UserEntity(String firstName,
                      String lastName,
                      Integer age,
                      String email,
                      Integer phoneNumber,
                      UserGender gender,
                      String education) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.education = education;
    }
}
