package com.mcode.alumninetwork3i.response;

import com.mcode.alumninetwork3i.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UserEntity user;
    private Boolean followedByAuthUser;
}

