package kz.agro.agrofarm.model.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

@Constraint(validatedBy = AgeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

    int minAge() default 18;

    String message() default "Age should be greater than {minAge}.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
