package kz.agro.agrofarm.model.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Samat Zhumamuratov
 */

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {

    String message() default "Phone number should be correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
