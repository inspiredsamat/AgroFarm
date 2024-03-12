package kz.agro.agrofarm.model.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Samat Zhumamuratov
 */

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

    private int minAge;

    @Override
    public void initialize(Age ageConstraintAnnotation) {
        minAge = ageConstraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        int age = Period.between(value, LocalDate.now()).getYears();
        return  age >= minAge;
    }
}
