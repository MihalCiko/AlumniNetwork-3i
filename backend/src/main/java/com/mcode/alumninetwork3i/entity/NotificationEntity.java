package com.mcode.alumninetwork3i.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity extends BaseEntity {

    @Column(nullable = false)
    private String type;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @OneToOne
    @JoinColumn(name = "owning_post_id")
    private PostEntity owningPost;

    @OneToOne
    @JoinColumn(name = "owning_comment_id")
    private CommentEntity owningComment;

    private Boolean isSeen;
    private Boolean isRead;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateUpdated;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateLastModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return id.equals(that.id) && type.equals(that.type) && receiver.equals(that.receiver) && owningPost.equals(that.owningPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, receiver, owningPost);
    }
}
