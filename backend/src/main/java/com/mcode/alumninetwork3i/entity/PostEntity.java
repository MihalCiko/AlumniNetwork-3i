package com.mcode.alumninetwork3i.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseEntity{

    @Column(length = 4096)
    private String content;
    private String postPhoto;
    private Integer likeCount;
    private Integer commentCount;
    private Integer shareCount;

    @Column(nullable = false)
    private Boolean isTypeShare;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateLastModified;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<CommentEntity> postComments = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "liker_id")
    )
    private List<UserEntity> likeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "shared_post_id")
    private PostEntity sharedPost;

    @JsonIgnore
    @OneToMany(mappedBy = "sharedPost")
    private List<PostEntity> shareList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagEntity> postTags = new ArrayList<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PostEntity post = (PostEntity) object;
        return Objects.equals(id, post.id) && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author);
    }
}
