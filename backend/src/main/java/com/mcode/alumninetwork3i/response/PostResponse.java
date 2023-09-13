package com.mcode.alumninetwork3i.response;

import com.mcode.alumninetwork3i.entity.PostEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private PostEntity post;
    private Boolean likedByAuthUser;
}
