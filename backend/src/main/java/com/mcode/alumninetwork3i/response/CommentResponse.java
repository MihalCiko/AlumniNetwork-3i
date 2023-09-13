package com.mcode.alumninetwork3i.response;

import com.mcode.alumninetwork3i.entity.CommentEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private CommentEntity comment;
    private Boolean likedByAuthUser;
}
