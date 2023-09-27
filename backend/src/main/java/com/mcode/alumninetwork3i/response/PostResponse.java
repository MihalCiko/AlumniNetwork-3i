package com.mcode.alumninetwork3i.response;

import com.mcode.alumninetwork3i.entity.Post;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Post post;
    private Boolean likedByAuthUser;
}
