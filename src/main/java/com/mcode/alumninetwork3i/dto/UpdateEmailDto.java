package com.mcode.alumninetwork3i.dto;

import com.mcode.alumninetwork3i.annotation.ValidEmail;
import com.mcode.alumninetwork3i.annotation.ValidPassword;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmailDto {
    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}