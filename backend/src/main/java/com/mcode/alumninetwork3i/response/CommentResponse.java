package com.mcode.alumninetwork3i.response;

import com.mcode.alumninetwork3i.entity.Comment;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private Comment comment;
    private Boolean likedByAuthUser;
}
