package com.mcode.alumninetwork3i.dto;

import com.mcode.alumninetwork3i.annotation.PasswordRepeatEqual;
import com.mcode.alumninetwork3i.annotation.ValidEmail;
import com.mcode.alumninetwork3i.annotation.ValidPassword;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PasswordRepeatEqual(
        passwordFieldFirst = "password",
        passwordFieldSecond = "passwordRepeat"
)
public class SignupDto {
    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
    private String passwordRepeat;

    @Size(max = 64)
    private String firstName;

    @Size(max = 64)
    private String lastName;
}
