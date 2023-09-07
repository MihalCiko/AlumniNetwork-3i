package com.mcode.alumninetwork3i.annotation;

import com.mcode.alumninetwork3i.validator.PasswordRepeatEqualValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordRepeatEqualValidator.class)
public @interface PasswordRepeatEqual {
    String message() default "Password mismatch";

    String passwordFieldFirst();

    String passwordFieldSecond();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
