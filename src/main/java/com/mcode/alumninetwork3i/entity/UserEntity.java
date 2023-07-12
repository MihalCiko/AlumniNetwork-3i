package com.mcode.alumninetwork3i.entity;

import com.mcode.alumninetwork3i.enums.UserGender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String email;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private String location;

    private String bio;

    // TODO Photo

    @OneToMany(mappedBy = "user")
    private List<EmploymentHistoryEntity> employmentHistoryEntities;

    @OneToMany(mappedBy = "userEducation")
    private List<EducationEntity> educationEntities;

    @ManyToMany
    @JoinTable(
            name = "applicants",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    Set<EventEntity> appliedEvents;

    @Convert(converter = ListConverter.class)
    private List<String> skills;

    @Convert(converter = ListConverter.class)
    private List<String> interest;

    public UserEntity(String firstName,
                      String lastName,
                      Date dateOfBirth,
                      String email,
                      Integer phoneNumber,
                      UserGender gender,
                      List<String> skills,
                      List<String> interest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.skills = skills;
        this.interest = interest;
    }
}
