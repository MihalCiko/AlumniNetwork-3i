package com.mcode.alumninetwork3i.dto;

import com.mcode.alumninetwork3i.annotation.PasswordRepeatEqual;
import com.mcode.alumninetwork3i.annotation.ValidPassword;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PasswordRepeatEqual(
        passwordFieldFirst = "password",
        passwordFieldSecond = "passwordRepeat"
)
public class UpdatePasswordDto {
    @ValidPassword
    private String password;
    private String passwordRepeat;

    private String oldPassword;
}