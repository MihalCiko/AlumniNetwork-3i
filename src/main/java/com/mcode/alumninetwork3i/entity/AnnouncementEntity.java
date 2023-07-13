package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "announcements")
public class AnnouncementEntity extends BaseEntity {

    private String type;

    // TODO ADD PHOTO

    private String information;

    public AnnouncementEntity(String type, String information) {
        this.type = type;
        this.information = information;
    }

}
