package com.mcode.alumninetwork3i.response;

import com.mcode.alumninetwork3i.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private User user;
    private Boolean followedByAuthUser;
}

